package com.w3e.fitbit.web;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.codec.binary.Base64;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.w3e.fitbit.model.fitbit.DailyActivitySummary;
import com.w3e.fitbit.service.account.SecurityServiceImpl;

/**
 * Controller of communication between W3E app and Fitbit
 * @author ZHOU WENTAO
 * */
@Controller
@RequestMapping("/fitbit/oauth")
public class FitbitOauthController {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${fitbit.oauth.security.clientId}")
	String clientId;
	
	@Value("${fitbit.oauth.security.clientSecret}")
	String clientSecret;
	
	@Value("${fitbit.oauth.security.authorizeUrl}")
	String authorizeUrl;
	
	@Value("${fitbit.oauth.security.accessTokenUrl}")
	String accessTokenUrl;
	
	@Value("${fitbit.oauth.security.revokeUrl}")
	String revokeUrl;
	
	@Value("${fitbit.oauth.security.scope}")
	String scope;
	
	@Value("${fitbit.oauth.resource.dailyActivitySummary}")
	String dailyActivitySummary;
	
	private final String RESPONSE_CODE = "code";
	private final String REDIRECT_URL = "http://localhost:8081/fitbit/oauth/getToken";
	private String requestType = "";
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
	
	/**
	 * Make a GET request to get access code
	 * */
	@RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
	public String getAuthCode(@RequestParam("type") String type) {
		
		requestType = type.isEmpty() ? "auth" : type;
        OAuthClientRequest accessCodeRequest = null;
		try {
			accessCodeRequest = OAuthClientRequest
					.authorizationLocation(authorizeUrl)
			        .setResponseType(RESPONSE_CODE)
			        .setClientId(clientId)
			        .setScope(scope)
			        .setRedirectURI(REDIRECT_URL)
			        .buildQueryMessage();
		} catch (OAuthSystemException e) {
			logger.error("Failed to get authorization code! Message: " + e.getMessage());
		}
 
        return "redirect:" + accessCodeRequest.getLocationUri();
	}
	
	/**
	 * Make a GET request to get token with access code
	 * */
	@RequestMapping(value = "/getToken", method = RequestMethod.GET)
	public String getToken(@RequestParam("code") String code) 
			throws JsonProcessingException, IOException {
		ResponseEntity<String> response = null;
		logger.info("Authorization code------" + code);
		
		// client ID and client secret
		String credentials = clientId + ":" + clientSecret;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String access_token_url = accessTokenUrl;
		access_token_url += "?code=" + code;
		access_token_url += "&grant_type=authorization_code";
		access_token_url += "&redirect_uri=" + REDIRECT_URL;

		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		
		// Get the Access Token From the received JSON response
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());
		String token = node.path("access_token").asText();
		logger.info("Access Token ---------" + token);
		
		// TODO should persistent token to optimize current business logic
		if (requestType.equalsIgnoreCase("REVOKE")) {
			// revoke action
			return "redirect:/fitbit/oauth/revokeAuth?token=" + token;
		} else {
			// access daily activity summary
			return "redirect:/fitbit/oauth/showActivities?token=" + token;
		}
		
	}
	
	/**
	 * Access daily activity summary resource with token
	 * */
	@RequestMapping(value = "/showActivities", method = RequestMethod.GET)
	public ModelAndView showActivities(@RequestParam("token") String token) 
			throws JsonProcessingException, IOException {
		//733SNS
		String url = dailyActivitySummary;

		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<>(headers1);

		ResponseEntity<DailyActivitySummary> activitySummary = restTemplate.exchange(url, HttpMethod.GET, entity, DailyActivitySummary.class);
		System.out.println(activitySummary);
		DailyActivitySummary summary = activitySummary.getBody();
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonSummary = ow.writeValueAsString(summary);

		ModelAndView model = new ModelAndView("showActivities");
		model.addObject("summary", jsonSummary);
		return model;
	}
	
	/**
	 * revoke existing token
	 * */
	@RequestMapping(value = "/revokeAuth", method = RequestMethod.GET)
	public ModelAndView revokeAuthorization(@RequestParam("token") String token) 
		throws JsonProcessingException, IOException {
		
		ResponseEntity<String> response = null;
		System.out.println("Authorization code------" + token);
		
		String credentials = clientId + ":" + clientSecret;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String revoke_token_url = revokeUrl;
		revoke_token_url += "?token=" + token;

		response = restTemplate.exchange(revoke_token_url, HttpMethod.POST, request, String.class);

		logger.info("Response Code ---------" + response.getStatusCode().value());
		
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("revokeStatus", String.valueOf(response.getStatusCode().value()));
		
		return model;
	} 
	
	
}
