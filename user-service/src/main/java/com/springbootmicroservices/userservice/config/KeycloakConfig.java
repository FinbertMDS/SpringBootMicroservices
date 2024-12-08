package com.springbootmicroservices.userservice.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    public static String serverUrl;
    public static String realm;
    public static String clientId;
    public static String clientSecret;
    public static String userName;
    public static String password;

    public KeycloakConfig(
            @Value("${keycloak.auth-server-url}") String serverUrl,
            @Value("${keycloak.realm}") String realm,
            @Value("${keycloakConfig.clientId}") String clientId,
            @Value("${keycloakConfig.clientSecret}") String clientSecret,
            @Value("${keycloakConfig.userName}") String userName,
            @Value("${keycloakConfig.password}") String password) {
                KeycloakConfig.serverUrl = serverUrl;
                KeycloakConfig.realm = realm;
                KeycloakConfig.clientId = clientId;
                KeycloakConfig.clientSecret = clientSecret;
                KeycloakConfig.userName = userName;
                KeycloakConfig.password = password;
    }

    @Bean
    public KeycloakConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public Keycloak keycloak() {
        return Keycloak.getInstance(serverUrl,
                realm,
                userName,
                password,
                clientId,
                clientSecret);
    }
}
