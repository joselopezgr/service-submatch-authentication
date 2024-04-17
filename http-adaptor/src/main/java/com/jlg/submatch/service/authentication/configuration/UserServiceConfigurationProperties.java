package com.jlg.submatch.service.authentication.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import reactor.util.annotation.NonNull;

@ConfigurationProperties(prefix = "adaptor.user-api")
public record UserServiceConfigurationProperties(
        @NonNull String baseUrl
) {
}
