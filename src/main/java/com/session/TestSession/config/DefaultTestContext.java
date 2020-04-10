package com.session.TestSession.config;

import java.io.Serializable;

public class DefaultTestContext implements TestContext, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6703632468271794160L;

	private TestRequest testRequest;

	public DefaultTestContext() {
		this(new DefaultTestRequest());
	}

	public DefaultTestContext(TestRequest testRequest) {
		this.testRequest = testRequest;
	}

	@Override
	public TestRequest getTestRequest() {
		return testRequest;
	}

}
