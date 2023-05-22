package com.app.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManagerBean;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManagerBean);
	}


	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				//	AUTHENTICATE USER BASED ON CLIENT_ID AND CLIENT_CODE
				.withClient("javainuse-client").secret(passwordEncoder.encode("javainuse-secret"))
				// CLIENT_CREDENTIALS TYPE WITH REFRESH TOKEN AND AUTHORIZATION CODE
				.authorizedGrantTypes(IdsConstant.CLIENT_CREDENTIALS.getValue(), IdsConstant.AUTHORIZATION_CODE.getValue())
				// READ AND WRITE ACCESS
				.scopes(IdsConstant.RESOURCE_SERVER_READ.getValue(), IdsConstant.RESOURCE_SERVER_WRITE.getValue())
				// ACCESS TOKEN VALIDATION TIMING
				.accessTokenValiditySeconds(120)
				.and()
//				AUTHENTICATE USER BASED ON USERNAME, PASSWORD, CLIENT_ID AND CLIENT_CODE
				.withClient("luffy").secret(passwordEncoder.encode("pirate"))
				// PASSWORD TYPE WITH REFRESH TOKEN AND AUTHORIZATION CODE
				.authorizedGrantTypes(IdsConstant.PASSWORD.getValue(), IdsConstant.REFRESH_TOKEN.getValue())
				// READ AND WRITE ACCESS
				.scopes(IdsConstant.READ.getValue(), IdsConstant.WRITE.getValue())
				// ACCESS TOKEN AND REFRESH TOKEN VALIDATION TIMING
				.accessTokenValiditySeconds(120)
	            .refreshTokenValiditySeconds(240000);
	}

}
