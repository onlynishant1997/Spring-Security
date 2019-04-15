package com.epam.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * The Class SpringMvcConfig.
 *
 * @author Nishant_Bansal
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.epam")
public class SpringMvcConfig implements WebMvcConfigurer {

	/**
	 * View resolver.
	 *
	 * @return the internal resource view resolver
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
