package templates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    
    /*@Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
*/
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/", "/registro").permitAll()
                //.antMatchers("/", "/signin").permitAll()
                .antMatchers(HttpMethod.POST, "/registro/registrar").permitAll()
                .antMatchers(HttpMethod.POST, "/guardarAsistencia").permitAll()
                .antMatchers("/asistentes").permitAll()
                .antMatchers("/user").permitAll()
                .antMatchers("/asistencia/user").permitAll()
                .antMatchers("/asistencia").permitAll()
                .antMatchers("/getAll").permitAll()
                .antMatchers("/asistentefolio").permitAll()
                .antMatchers("/obtenerPilaresTodos").permitAll()
                .antMatchers("/obtenerActividadesPorPilar").permitAll()
                //.antMatchers("/registrationConfirm*").permitAll()
                 .antMatchers("/login*").permitAll()
                .antMatchers("/badUser*").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/doctos/**").permitAll()
                .antMatchers("/js/**").permitAll()
                //.antMatchers("/user/**").permitAll()
                .antMatchers("/font-awesome/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
	            .loginPage("/")
	            .loginProcessingUrl("/j_spring_security_check")
	            .defaultSuccessUrl("/home.html")
	            .failureUrl("/login?error=true")
	            //.successHandler(myAuthenticationSuccessHandler)
	            .usernameParameter("j_username")
	            .passwordParameter("j_password")
	        .permitAll()
	            .and()
	        .sessionManagement()
	            .invalidSessionUrl("/invalidSession.html")
	            .sessionFixation().none()
	            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
	        .and()
	        .logout()
	            .invalidateHttpSession(false)
	            .logoutUrl("/j_spring_security_logout")
	            .logoutSuccessUrl("/home?logSucc=true").permitAll()
	            .deleteCookies("JSESSIONID")
	            .permitAll();
    }
	/*
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }*/
	
	public void configure(final WebSecurity web) throws Exception {
		
		web.ignoring()
        .antMatchers("/resources/**")
        .antMatchers("/css/**")
        .antMatchers("/js/**")
        .antMatchers("/webjars/**");
	}
	
    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
    
   /* 
    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }*/
}
