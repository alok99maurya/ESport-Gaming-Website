package com.esport.gamics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public UserDetailsService getUserDetailsSevice() {
		return new CustomUserService();
	}
	@Bean
	public BCryptPasswordEncoder getEncode() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider getauth() {
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		dao.setUserDetailsService(getUserDetailsSevice());
		dao.setPasswordEncoder(getEncode());
		return dao;
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(getauth());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests().antMatchers("/user/**").hasRole("USER")
		.antMatchers("/creater/**").hasRole("CREATER")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/sponsor/**").hasRole("SPONSOR")
		.antMatchers("/**").permitAll().and().formLogin().loginPage("/join")
		.loginProcessingUrl("/dologin").defaultSuccessUrl("/home").and().csrf().disable();
	}
}
