package com.session.TestSession.config;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class TestConfiguration {

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	protected TestRequest testRequest(@Value("#{request.parameterMap}") Map<String, String[]> parameters, 
			@Value("#{request.getAttribute('currentUri')}") String currentUri) {
		DefaultTestRequest request = new DefaultTestRequest(parameters);
		request.setCurrentUri(currentUri);
		return request;
	}

	@Configuration
	protected static class TestContextConfiguration {

		@Resource
		@Qualifier("testRequest")
		private TestRequest testRequest;

		@Bean
		@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
		public TestContext testContext() {
			return new DefaultTestContext(testRequest);
		}

	}

}
