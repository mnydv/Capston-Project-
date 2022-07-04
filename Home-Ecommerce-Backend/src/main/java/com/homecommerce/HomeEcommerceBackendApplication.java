package com.homecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.homecommerce.models.Admin;
import com.homecommerce.services.AdminService;

@SpringBootApplication
public class HomeEcommerceBackendApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HomeEcommerceBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HomeEcommerceBackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AdminService srv) {
	    return (args) -> {
	    	if(srv.count()==0) {
	    		srv.updateAdmin(new Admin("admin", "admin", "Administrator"));
	    		log.info("Admin user created successfully");
	    	}
	    };
	}

}
