package mx.edu.uacm.centrocomunitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "basicForm", method = RequestMethod.POST)
    public String basicForm(int id, String name, String password, String email) {
		System.out.println("entre");
		System.out.println(" "+name);
		return "login.html"; 
}
}