package fr.ans.psc.pscmajui.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RootController {

	private static String RETURNED_PAGE="layout";
	//private static String INCLUDED_CONTENT="root :: &#35;modop-form";
	private static String INCLUDED_CONTENT="welcome";
	//private static String INCLUDED_CONTENT="page non definie";
	
	@GetMapping("/")
	public String root(Model model) {	
		log.info("RootController IN . Pas de paramètre");		
		model.addAttribute("content", INCLUDED_CONTENT);
		log.info("RootController OUT returnedPage={} , includedContent={} ",RETURNED_PAGE, INCLUDED_CONTENT );		
		return RETURNED_PAGE;
	}
	
//	@GetMapping("/")
//	public String root(Model model) {	
//		log.info("RootController IN . Pas de paramètre");		
//		model.addAttribute("content", INCLUDED_CONTENT);
//		log.info("RootController OUT returnedPage={} , includedContent={} ",RETURNED_PAGE, INCLUDED_CONTENT );		
//		return RETURNED_PAGE;
//	}
}

