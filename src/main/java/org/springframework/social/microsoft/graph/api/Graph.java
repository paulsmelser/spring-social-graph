package org.springframework.social.microsoft.graph.api;

import org.springframework.social.ApiBinding;
import org.springframework.social.microsoft.graph.http.logging.LogLevel;

public interface Graph extends ApiBinding {
	String PROVIDER_ID = "microsoft-graph";
	void enableSlf4j(LogLevel level);
}
