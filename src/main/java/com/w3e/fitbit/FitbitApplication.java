package com.w3e.fitbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * entry point of application
 * @author ZHOU WENTAO
 * */
@SpringBootApplication
public class FitbitApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FitbitApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(FitbitApplication.class, args);
	}

}

