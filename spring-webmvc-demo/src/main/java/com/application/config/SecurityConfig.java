package com.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailService(PasswordEncoder encoder) {
		UserDetails user = User.withUsername("alice")
				.password(encoder.encode("alicepass"))
				.roles("USER")
				.build();
		
		UserDetails admin = User.withUsername("bob")
				.password(encoder.encode("bobpass"))
				.roles("USER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")           // custom login page
            .loginProcessingUrl("/perform_login") // URL Spring Security listens for POST
            .defaultSuccessUrl("/default") // after login, redirect here
            .failureUrl("/login?error=true")
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout=true")
            .permitAll()
        )
//        .csrf(csrf -> csrf.ignoringRequestMatchers("/logout"))
        .exceptionHandling(ex -> ex
            .accessDeniedPage("/accessDenied")
        );

		return http.build();
	}
}