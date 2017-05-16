package org.springframework.social.microsoft.graph.api;

import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.social.microsoft.graph.connect.ApiVersionParameterRequestInterceptor;
import org.springframework.social.microsoft.graph.http.logging.LogLevel;
import org.springframework.social.microsoft.graph.http.logging.LoggingRequestInterceptor;
import org.springframework.social.microsoft.graph.http.logging.Slf4jHttpRequestResponseLogger;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.web.client.RestTemplate;

public class GraphTemplate extends AbstractOAuth2ApiBinding implements Graph {
	public GraphTemplate(String accessToken, String apiVersion) {
		super(accessToken);
		addVersionInterceptor(apiVersion);
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		BufferingClientHttpRequestFactory requestFactory = new BufferingClientHttpRequestFactory(factory);
		restTemplate.setRequestFactory(requestFactory);
	}

	@Override
	public void enableSlf4j(LogLevel level) {
		getRestTemplate().getInterceptors()
				.add(new LoggingRequestInterceptor(new Slf4jHttpRequestResponseLogger(getClass(), level)));
	}

	private void addVersionInterceptor(String apiVersion) {
		getRestTemplate().getInterceptors().add(new ApiVersionParameterRequestInterceptor(apiVersion));
	}
}
