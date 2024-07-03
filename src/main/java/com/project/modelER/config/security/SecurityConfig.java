package com.project.modelER.config.security;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//
//@Configuration
//@EnableWebSecurity

public class SecurityConfig {
	//Logger
//	
//	@Autowired
//	private AuthenticationSuccesHandler succes;
//	
//	@Bean 
//	public UserDetailsManager userDetailsService(DataSource dataSource) {
//		new JdbcUserDetailsManager(dataSource);
//		}
//	
//	@Bean public SecurityFilterChain securityFilterChain (HttpSecurity http) trhows Exception {
//		log.info("[securityFilterChain]");
//		
//		http.authorizeHttpRequest(authz -> authz)
//		//Mal
//		.requestMatchers("/register").permitAll()
//		.requestMatchers(HttpMethod.GET,
//				"/login","/index","/css/**", "/level??".permitAll())
//		.requestMatchers("/admin/**").hasRole("ADMIN")
//		.anyRequest(). authenticated())
//	
//		.form
//	}
}
