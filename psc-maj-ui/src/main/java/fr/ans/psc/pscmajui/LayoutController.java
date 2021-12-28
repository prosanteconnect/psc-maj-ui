package fr.ans.psc.pscmajui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LayoutController {

	@GetMapping("/")
	public String root() {		
		return "layout";
	}
}
