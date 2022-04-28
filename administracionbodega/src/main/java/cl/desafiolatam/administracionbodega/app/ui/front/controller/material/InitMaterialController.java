package cl.desafiolatam.administracionbodega.app.ui.front.controller.material;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitMaterialController {
	@GetMapping("/material")
	public String init(ModelMap modelMap) {
		return "/material/init";
	}
}
