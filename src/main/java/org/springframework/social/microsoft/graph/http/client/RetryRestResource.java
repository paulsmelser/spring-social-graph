package org.springframework.social.microsoft.graph.http.client;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.social.microsoft.graph.http.client.retry.RetryService;
import org.springframework.web.client.RestTemplate;

public class RetryRestResource extends RestResource {
	private final RetryService retryService;

	public RetryRestResource(RestTemplate restTemplate, String resourceBaseUri, RetryService retryService) {
		super(restTemplate, resourceBaseUri);
		this.retryService = retryService;
	}

	@Override
	public <T, R> ResponseEntity<R> execute(URI uri, HttpMethod httpMethod, HttpEntity<T> entity, Class<R> responseType) {
		return retryService.doWithRetry(() -> {
					System.out.println("retry");
					return getRestTemplate().exchange(
							uri,
							httpMethod,
							entity,
							responseType
					);
				}
		);
	}

	@Override
	public <T, R> ResponseEntity<R> execute(URI uri, HttpMethod httpMethod, HttpEntity<T> entity, ParameterizedTypeReference<R> responseType) {
		return retryService.doWithRetry(() -> {
					System.out.println("retry");
					return getRestTemplate().exchange(
							uri,
							httpMethod,
							entity,
							responseType
					);
				}
		);
	}

	@Override
	public ResponseEntity delete(URI uri, HttpHeaders headers) {
			return retryService.doWithRetry(() -> getRestTemplate().exchange(uri, HttpMethod.DELETE, new HttpEntity<>(headers), String.class));
	}
}
