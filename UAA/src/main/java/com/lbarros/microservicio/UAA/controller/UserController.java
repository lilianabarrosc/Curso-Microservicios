package com.lbarros.microservicio.UAA.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Resource(name = "tokenStore")
	JwtTokenStore jwtTokenStore;
	
	@Resource(name = "tokenServices")
	ConsumerTokenServices tokenServices;

	@GetMapping("/user")
	public Principal retrievePrincipal(Principal principal) {
		return principal;
	}
	
	//@PreAuthorize("#oauth2.hasScope('write')")
	@GetMapping("/scope")
	public String prueba() {	
		return "Pasamos la prueba";
	}

	@GetMapping("/tokens")
	public List<String> getTokens(String client_id, String user) {
		List<String> tokenValues = new ArrayList<String>();
		Collection<OAuth2AccessToken> tokens = jwtTokenStore.findTokensByClientIdAndUserName(client_id, user);
		if (tokens != null) {
			for (OAuth2AccessToken token : tokens) {
				tokenValues.add(token.getValue());
			}
		}
		return tokenValues;
	}

	@PostMapping("/token/revoke")
	public String revokeToken(@RequestHeader("Authorization") String auth) {
		tokenServices.revokeToken(auth.substring(7));
		return auth.substring(7);
	}
	
	//en memoria no revoca tokens
	@PostMapping("/refreshtoken/revoke")
	public String revokeRefreshToken(@RequestHeader("Authorization") String auth) {
	    if (jwtTokenStore instanceof JwtTokenStore){
	    	System.out.println("Eliminar token refresh");
	    	OAuth2RefreshToken oauth2RefreshToken=jwtTokenStore.readRefreshToken(auth);
	        ((JwtTokenStore) jwtTokenStore).removeRefreshToken(oauth2RefreshToken);
	    }
	    return auth.substring(7);
	} 
}
