package org.springframework.social.microsoft.graph.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.microsoft.graph.api.Graph;
import org.springframework.social.oauth2.OAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class GraphConnectionFactory extends OAuth2ConnectionFactory<Graph> {

	public GraphConnectionFactory(String apiVersion, String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl){
		this(Graph.PROVIDER_ID, new GraphServiceProvider(new OAuth2Template(clientId, clientSecret, authorizeUrl, accessTokenUrl), apiVersion), new GraphApiAdaptor());
	}

	public GraphConnectionFactory(String providerId, OAuth2ServiceProvider<Graph> serviceProvider, ApiAdapter<Graph> apiAdapter) {
		super(providerId, serviceProvider, apiAdapter);
	}
}
