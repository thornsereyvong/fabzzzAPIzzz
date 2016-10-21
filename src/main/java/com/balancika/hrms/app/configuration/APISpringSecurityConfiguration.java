//package com.balancika.hrms.app.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableWebSecurity
//public class APISpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//			.withUser("developer")
//			.password("BalancikaHRM!@#$%^&*Developer")
//			.roles("Developer");
//			//ZGV2ZWxvcGVyOkJhbGFuY2lrYUhSTSFAIyQlXiYqRGV2ZWxvcGVy
//			//"Authorization" : "Basic ZGV2ZWxvcGVyOkJhbGFuY2lrYUhSTSFAIyQlXiYqRGV2ZWxvcGVy"
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.antMatcher("/api/**").authorizeRequests().anyRequest().hasAnyRole("Developer");
//		http.exceptionHandling().accessDeniedPage("/accessDeined");
//		http.csrf().disable();
//		http.httpBasic();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}
//
//}
