package org.springframework.social.microsoft.graph.connect;

import org.springframework.social.microsoft.graph.api.Graph;
import org.springframework.social.microsoft.graph.api.GraphTemplate;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

public class GraphServiceProvider implements OAuth2ServiceProvider<Graph> {
	private String apiVersion;
	private OAuth2Operations oAuth2Operations;

	public GraphServiceProvider(OAuth2Operations oAuth2Operations){
		this(oAuth2Operations, "beta");
	}

	public GraphServiceProvider(OAuth2Operations oAuth2Operations, String apiVersion){
		this.oAuth2Operations = oAuth2Operations;
		this.apiVersion = apiVersion;
	}

	@Override
	public OAuth2Operations getOAuthOperations() {
		return oAuth2Operations;
	}

	@Override
	public Graph getApi(String accessToken) {
		return new GraphTemplate(accessToken, apiVersion);
	}
}
