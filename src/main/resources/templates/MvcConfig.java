package templates;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro").setViewName("registro");
        registry.addViewController("/asistencia").setViewName("asistencia");
        registry.addViewController("/getAll").setViewName("asistencia");
        registry.addViewController("/usuario").setViewName("asistencia");
        registry.addViewController("/showNewUserForm").setViewName("new_user");
        registry.addViewController("/console.html");
        
    }
	
	
	
	
}
