package fr.ans.psc.pscmajui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;


@Configuration
public class ProviderPSC  {
	 
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.proSanteConnectClientRegistration());
    }

    private ClientRegistration proSanteConnectClientRegistration() {
    	
    	return ClientRegistration.withRegistrationId("PROSANTECONNECT")
                .clientId("ans-parrainage-bas")
                .clientSecret("5e609e45-ee6c-4854-93a0-91a44aa953bb")
              //  .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_JWT)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                //.redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid","scope_all" )                
                .authorizationUri("https://wallet.bas.esw.esante.gouv.fr/auth")
                .redirectUri("https://psc-ws-maj.test.psc.api.esante.gouv.fr/ui/auth/prosanteconnect/callback")
              //  .redirectUri("{baseUrl}/prosanteconnect/callback")
                
                //.tokenUri("https://auth.bas.esw.esante.gouv.fr/auth/realms/esante-wallet/protocol/openid-connect")    
                .tokenUri("https://auth.bas.esw.esante.gouv.fr/auth/realms/esante-wallet/protocol/openid-connect/token")
                
                //.userInfoUri("https://auth.bas.esw.esante.gouv.fr/auth/realms/esante-wallet/protocol/openid-connect/token")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                //.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                //.clientName("Google")
                .build();
    	   	 
    }
    
 
       
}
