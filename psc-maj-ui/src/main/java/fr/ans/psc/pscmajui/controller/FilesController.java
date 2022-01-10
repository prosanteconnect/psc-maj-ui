package fr.ans.psc.pscmajui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FilesController {

	private static String RETURNED_PAGE="layout";
	private static String INCLUDED_CONTENT="upload_recup";
	
	
	@GetMapping("/files")
//	@PostMapping("/auth/prosanteconnect/callback")
	public String layout(Model model) {		
		log.info("FilesController IN . Pas de paramètre");		
		model.addAttribute("content", INCLUDED_CONTENT);
		log.info("FilesController OUT returnedPage={} , includedContent={} ",RETURNED_PAGE, INCLUDED_CONTENT );		
		return RETURNED_PAGE;
	}
}
