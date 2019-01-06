package com.w3e.fitbit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.w3e.fitbit.model.account.User;
import com.w3e.fitbit.service.account.SecurityService;
import com.w3e.fitbit.service.account.UserService;
import com.w3e.fitbit.validator.UserValidator;

/**
 * W3E account controller
 * @author ZHOU WENTAO
 * */
@Controller
public class UserController {

	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
	RestTemplate restTemplate;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
		
        return "welcome";
    }
    
    @RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
    public ModelAndView deleteAccount(){
    	long userId = userService.getCurrentAuthorizedUserId();
    	if (userId != -1) {
    		userService.deleteUserById(userId);
    		ModelAndView model = new ModelAndView("login"); 
    		model.addObject("message", "Your W3E account has been removed successfully.");
    		return model;
    	} else {
    		ModelAndView model = new ModelAndView("welcome");
    		model.addObject("deleteStatus", "FAILED");
        	return model;
    	}    	
    }
}
