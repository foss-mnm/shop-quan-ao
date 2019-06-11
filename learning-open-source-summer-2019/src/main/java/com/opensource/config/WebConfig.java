package com.opensource.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.opensource.service.UserDetailsServiceImpl;

//@Configuration
//@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEnCoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) {
		try {
			authentication.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEnCoder());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void configure() {
		
	}
}
