package org.springframework.social.microsoft.graph.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.microsoft.graph.api.Graph;

public class GraphApiAdaptor implements ApiAdapter<Graph> {
	@Override
	public boolean test(Graph api) {
		return false;
	}

	@Override
	public void setConnectionValues(Graph api, ConnectionValues values) {

	}

	@Override
	public UserProfile fetchUserProfile(Graph api) {
		return null;
	}

	@Override
	public void updateStatus(Graph api, String message) {

	}
}
