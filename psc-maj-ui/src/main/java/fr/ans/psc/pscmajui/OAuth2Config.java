package fr.ans.psc.pscmajui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class OAuth2Config extends WebSecurityConfigurerAdapter{

	
//	@Override
//    protected void configure(HttpSecurity security) throws Exception {
// 		log.info("OAuth2LoginConfig::configure   HttpSecurity");		
// 		security.httpBasic().disable();
//	}

	
	 public OAuth2Config() {		 
		super(false); //true => disableDefaults configuration
		log.info("APPEL Oauth2Config ");
	}

	@Override
	    protected void configure(HttpSecurity security) throws Exception {
	 		log.info("OAuth2LoginConfig::configure   HttpSecurity");
	 		
	 		security.authorizeRequests()
	 	//      .mvcMatchers("/","/error").permitAll()
	 	      .mvcMatchers("/","/error","/ui/auth/prosanteconnect/callback","/auth/prosanteconnect/callback","/login").permitAll()	 	    
	 	   //  .mvcMatchers("/","/error","files").permitAll()
	 	      .mvcMatchers("/files").authenticated()
	 	//     .mvcMatchers("/auth/prosanteconnect/callback").authenticated()
	 	      .and().oauth2Login()
	 	      .redirectionEndpoint();
	 	     
	}
	 		
	//security = security.cors().and().csrf().disable();
	

    // Set session management to stateless
//    security = security
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and();

    // Set permissions on endpoints

	 		/*
    security.authorizeRequests()
            // Our public endpoints, secured endpoints and then open everything else that is static resource stuff
    			.antMatchers(HttpMethod.GET, "/").permitAll()
    			.anyRequest().authenticated();
    			//.antMatchers("/files").authenticated()
    			//.and().httpBasic().and().csrf().disable();
    			*/     
    		
	 /*		
	 		security
	 	   .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	 	      .cors().and()
	 	            .authorizeRequests()
	 	            .antMatchers(HttpMethod.GET, "/public/**").permitAll()
	 	            .antMatchers(HttpMethod.POST, "/login").permitAll()
	 	            .anyRequest().authenticated().
	 	            .and()
	 	            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
	 	            .addFilter(new JWTAuthorizationFilter(authenticationManager()));
	 	}
	 	*/
//	 		security            
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authorizeRequests()
//            .mvcMatchers("/").permitAll();
            /*.anyRequest().authenticated()
            .and()
            .addFilterBefore(new JwtAuthenticationFilter(tokenService),
                    UsernamePasswordAuthenticationFilter.class);*/
//    }

//		@Override
//		public void configure(WebSecurity web) throws Exception {
//		//  web.ignoring().antMatchers("/error**","/resources/**", "/static/**", "/css/**", "/js/**", "/img/**","/templates/**", "/public/**");
//			  web.ignoring().antMatchers("/error**","resources/**", "static/**", "css/**", "js/**", "img/**","templates/**", "public/**");
////		  web.ignoring().antMatchers("/resources/**");
//		}

	}

