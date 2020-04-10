package com.session.TestSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
public class TestSessionApplication /* extends SpringBootServletInitializer */ {

	public static void main(String[] args) {
		SpringApplication.run(TestSessionApplication.class, args);
	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(TestSessionApplication.class); }
	 */

}
