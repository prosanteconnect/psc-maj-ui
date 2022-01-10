package fr.ans.psc.pscmajui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Login {
	private static String RETURNED_PAGE="layout";
	//private static String INCLUDED_CONTENT="root :: &#35;modop-form";
	private static String INCLUDED_CONTENT="welcome";
	//private static String INCLUDED_CONTENT="page non definie";
	
	@GetMapping("/login")
	public String root(Model model) {	
		log.info("RootController IN . Pas de paramètre");		
		model.addAttribute("content", INCLUDED_CONTENT);
		log.info("RootController OUT returnedPage={} , includedContent={} ",RETURNED_PAGE, INCLUDED_CONTENT );		
		return RETURNED_PAGE;
	}
}
