package com.in30minutes.springboot.myfirstwebapp.security;
import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
@Bean
public InMemoryUserDetailsManager createUserDetails() {
	String username = "ShahidKhan";
	String password = "dummy";
	UserDetails user1=setUserandPass(username, password);
	UserDetails user2=setUserandPass("NikhatKhan", "dummy");
	return new InMemoryUserDetailsManager(user1,user2);
	
			}
private UserDetails setUserandPass(String username, String password) {
	Function<String,String> passwordEncoder=input->passwordEncoder().encode(input);
	UserDetails userDetais=User.builder()
			.passwordEncoder(passwordEncoder)
			.username(username)
			.password(password)
			.roles("USER","ADMIN")
			.build();
	return userDetais;
}
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	
	http.authorizeHttpRequests(
			auth -> auth.anyRequest().authenticated());
	http.formLogin(withDefaults());
	
	http.csrf(csrf -> csrf.disable());
    http.headers(header -> header.frameOptions(frameOptions -> frameOptions.disable()));
	
	return http.build();
}

}
