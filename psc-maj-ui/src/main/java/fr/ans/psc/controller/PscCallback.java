package fr.ans.psc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PscCallback {

	private static String RETURNED_PAGE="layout";
	private static String INCLUDED_CONTENT="upload_recup";
	
	@GetMapping("/prosanteconnect/callback")
	public String layout(Model model) {		
		log.info("PscCallback IN . ");		
		model.addAttribute("content", INCLUDED_CONTENT);
		log.info("PscCallback OUT returnedPage={} , includedContent={} ",RETURNED_PAGE, INCLUDED_CONTENT );		
		return RETURNED_PAGE;

	}
}
