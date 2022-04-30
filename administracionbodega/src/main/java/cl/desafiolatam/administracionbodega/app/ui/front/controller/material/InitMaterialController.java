package cl.desafiolatam.administracionbodega.app.ui.front.controller.material;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class InitMaterialController {
	@GetMapping("/material")
	public String init(ModelMap modelMap, HttpSession session) {
		return "/material/init";
	}
}
