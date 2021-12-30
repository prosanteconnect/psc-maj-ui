package fr.ans.psc.pscmajui;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Configuration
//@EnableWebSecurity
public class OAuth2Config extends WebSecurityConfigurerAdapter{
	
	/*
	
	 public OAuth2Config() {		 
		super(false); //true => disableDefaults configuration
		log.info("APPEL Oauth2Config ");
	}

	@Override
	    protected void configure(HttpSecurity security) throws Exception {
	 		log.info("OAuth2LoginConfig::configure   HttpSecurity");
	security = security.cors().and().csrf().disable();

    // Set session management to stateless
    security = security
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and();

    // Set permissions on endpoints
    security.authorizeRequests()
            // Our public endpoints, secured endpoints and then open everything else that is static resource stuff
    			.antMatchers(HttpMethod.GET, "/").permitAll()
    			.antMatchers("/files").authenticated()
    			.and().httpBasic().and().csrf().disable();    
    }
	*/
}