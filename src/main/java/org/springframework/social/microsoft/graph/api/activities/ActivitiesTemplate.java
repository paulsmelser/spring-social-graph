package org.springframework.social.microsoft.graph.api.activities;

import org.springframework.social.microsoft.graph.api.AbstractTemplate;
import org.springframework.social.microsoft.graph.api.Graph;
import org.springframework.social.microsoft.graph.http.client.RestResource;

public class ActivitiesTemplate extends AbstractTemplate implements ActivitiesOperations {
	private final RestResource restResource;

	protected ActivitiesTemplate(RestResource restResource, boolean isAuthorized) {
		super(isAuthorized);
		this.restResource = restResource;
	}


	@Override
	protected String getProviderId() {
		return Graph.PROVIDER_ID;
	}
}
