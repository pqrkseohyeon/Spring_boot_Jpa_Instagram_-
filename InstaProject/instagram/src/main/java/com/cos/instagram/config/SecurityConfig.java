package com.cos.instagram.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration //해당 클래스를 Configuration으로 등록
@EnableWebSecurity //Spring Security 활성화
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 1. Bean 어노테이션은 메서드에 붙여서 객체 생성시 사용
	// 비밀번호를 복호화/암호화하는 로직이 담긴 객체를 Bean으로 등록
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	// 2. 필터링
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().disable();
		http.authorizeRequests()
		.antMatchers("/user/**", "/follow/**", "/image/**")
		.authenticated()
		.anyRequest()
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/auth/login")
		.loginProcessingUrl("/auth/loginProc")
		.defaultSuccessUrl("/image/feed");

	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	// 내가 인코딩하는게 아니라, 어떤 인코딩으로 패스워드가 만들어졌는지 알려준다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
	}
	
	



}
