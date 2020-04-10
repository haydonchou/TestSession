package com.session.TestSession.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session.TestSession.config.TestContext;
import com.session.TestSession.config.TestRequest;

@RestController
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@Autowired
//	private OAuth2ClientContext oauth2ClientContext;
	private TestContext testContext;

	@GetMapping("/public/test")
	public String testSession() {
		log.error("hi");
//		AccessTokenRequest request = oauth2ClientContext.getAccessTokenRequest();
//		return request.getAuthorizationCode();
		TestRequest testRequest = testContext.getTestRequest();
		return testRequest.getCode();
	}

}
