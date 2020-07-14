/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.interactiveblackboard.springsecurity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
/**
 *
 * @author Juaco
 *  
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/bb2").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
                List<UserDetails> userList = new ArrayList<>();
		UserDetails userRegister1 =
			 User.withDefaultPasswordEncoder()
				.username("usuarioprueba1")
				.password("password1")
				.roles("USER")
				.build();
                userList.add(userRegister1);

		UserDetails userRegister2 =
			 User.withDefaultPasswordEncoder()
				.username("usuarioprueba2")
				.password("password2")
				.roles("USER")
				.build();          
                
                userList.add(userRegister2);

		return new InMemoryUserDetailsManager(userList);
	}
}
