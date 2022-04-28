package cl.desafiolatam.administracionbodega.app.ui.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login(ModelMap modelMap) {
		return "login";
	}
	
	@GetMapping("/Deslogin")
	public String deslogin() {
		return "login";
	}
}
