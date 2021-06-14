package mx.edu.uacm.centrocomunitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uacm.centrocomunitario.entity.User;
import mx.edu.uacm.centrocomunitario.service.UserService;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	private UserService userService;
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	
    public String basicForm(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String direccion,
    		String correo, String telefono, String sexo, Model model) {
		System.out.println("entre a registro");
		User u = new User();
//		u.setNombre(nombre);
//		u.setApellidoPaterno(apellidoPaterno);
//		u.setApellidoMaterno(apellidoMaterno);
//		u.setEdad(edad);
//		u.setDireccion(direccion);
//		u.setCorreo(correo);
//		u.setTelefono(telefono);
//		u.setSexo(sexo);
//		
//		u=userService.addUser(u);
		model.addAttribute("usuario", u);
		return "index :: #rest"; 
	}
}
