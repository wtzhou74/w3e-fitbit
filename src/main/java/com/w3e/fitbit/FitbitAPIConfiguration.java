package com.w3e.fitbit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * configuration
 * @author ZHOU WENTAO
 * */
@Configuration
public class FitbitAPIConfiguration {
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
