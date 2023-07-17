package com.example.demo;

import com.glodon.coral.meta.service.core.EnableServiceMetaRoute;
import com.glodon.coral.webflux.security.EnableServiceRouteSecurity;
import com.glodon.coral.webflux.tenancy.EnableTenancyControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableServiceMetaRoute
@EnableTenancyControl
@EnableServiceRouteSecurity
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
