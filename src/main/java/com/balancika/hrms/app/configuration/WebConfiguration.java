package com.balancika.hrms.app.configuration;

import java.util.Base64;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.balancika.hrms.app")
@PropertySource(value = {"classpath:application.properties"})
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter{
	@Autowired
	private Environment environment;

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("dataSource.url"));
		dataSource.setUsername(environment.getRequiredProperty("dataSource.username"));
		dataSource.setPassword(environment.getRequiredProperty("dataSource.password"));
		return dataSource;
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		return new AcceptHeaderLocaleResolver();
	}
	
	@Bean
	public HttpHeaders httpHeaders(){
		HttpHeaders h = new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_JSON);
		String credentials = environment.getRequiredProperty("api.name")+":"+environment.getRequiredProperty("api.pass");
		String base = Base64.getUrlEncoder().encodeToString(credentials.getBytes());
		h.set("Authorization", "Basic " + base);
		return h;
	}
	
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate r = new RestTemplate();
		r.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		r.getMessageConverters().add(new StringHttpMessageConverter());
		return r;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setMaxUploadSize(1000000000);
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}
	
	
}
