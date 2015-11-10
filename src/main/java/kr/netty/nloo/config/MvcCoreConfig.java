package kr.netty.nloo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "kr.netty.nloo.web" })
public class MvcCoreConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
	 	ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
	 	List<ViewResolver> viewResolvers = new ArrayList<>();
	 	viewResolvers.add(internalResourceViewResolver());
	 	viewResolvers.add(beanNameViewResolver());
		contentNegotiatingViewResolver.setViewResolvers(viewResolvers );
		contentNegotiatingViewResolver.setContentNegotiationManager(manager);
		return contentNegotiatingViewResolver;
	}
	
	@Bean
	@Description("Default viewClass: JSTL view (JSP with html output)")
	public ViewResolver internalResourceViewResolver() {
		// Example: a logical view name of 'vets' is mapped to
		// '/WEB-INF/jsp/vets.jsp'
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	@Bean
	@Description("Used for 'xml' views")
	public ViewResolver beanNameViewResolver() {
		return new BeanNameViewResolver();
	}
	
}
