package com.sCore.config.auth;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VfAccessTokenConverter extends DefaultAccessTokenConverter {
	
    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
    	if (claims == null || claims.isEmpty()) {
    		return null;
    	}
        OAuth2Authentication authentication = super.extractAuthentication(claims);
        authentication.setDetails(claims);
        return authentication;
    }
}