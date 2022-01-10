package fr.ans.psc.pscmajui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ans.psc.pscmajui.ProviderPSC;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class PscCallback {
	
//	@Autowired
//	OAuth2AuthorizationContext clientContext;

	@Autowired
	ProviderPSC psc;

	private static String RETURNED_PAGE="layout";
	private static String INCLUDED_CONTENT="upload_recup";
	//private static String INCLUDED_CONTENT="sharpNotSUpported";
	
	@GetMapping("auth/prosanteconnect/callback")	
	public String layout(
            @RequestParam(value = "state", required = true) String state,
            @RequestParam(value = "session_state", required = true) String session_state,
            @RequestParam(value = "code", required = true) String code,
            Model model) {
		log.debug("PscCallback IN ");		
		
		log.debug("client secret: {} " + psc.clientRegistrationRepository().findByRegistrationId("PROSANTECONNECT").getClientSecret());

	//	log.debug("--- " + clientContext.getAttributes().toString());
//		OAuth2AuthorizedClient client =
//			    clientService.loadAuthorizedClient(
//			            oauthToken.getAuthorizedClientRegistrationId(),
//			            oauthToken.getName());
//			String accessToken = client.getAccessToken().getTokenValue();
			
		
		log.debug("PscCallback state: {} \n session_state: {} \n code: {}", state, session_state, code);		
		
		Authentication authentication =
			    SecurityContextHolder
			        .getContext()
			        .getAuthentication();
		
		
		
		log.debug("authentication réf:{}", authentication);	
		log.debug("authentication isconnected: {}", authentication.isAuthenticated());	
		log.debug("authentication getPrincipal ref: {}", authentication.getPrincipal());	
		log.debug("authentication getDetails ref: {}", authentication.getDetails());	
		log.debug("authentication getName ref: {}", authentication.getName());
		
		//recup du token pour userInfo
		
		//génération d'un token propre à l'appli
		
		model.addAttribute("content", INCLUDED_CONTENT);
		log.debug("PscCallback OUT returnedPage={} , includedContent={} ",RETURNED_PAGE, INCLUDED_CONTENT );		
		return RETURNED_PAGE;

	}
}
