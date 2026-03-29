package edu.npu.zu.config;

import javax.sql.DataSource;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import edu.npu.zu.resthandlers.JerseyRestApplicationConfig;

/* Note: Some additional configuration is done through properties in the application.properties file.  SpringBoot
 * looks at application.properties as part of its automatic configuration of Spring MVC
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class UnivAppConfig {
	@Autowired
    private Environment env;
	
	@Bean
    public DataSource dataSource() {
		/*  Per the Spring Boot Documentation: DataSourceBuilder is a convenience class for building a DataSource with common implementations and properties. If HikariCP, Tomcat or Commons DBCP are on the classpath 
		 *  one of them will be selected (in that order with Hikari first).  With the Spring Boot configuration we have for this project
		 *  we should be using Hikari as the connection pool provider.
		 */
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(env.getProperty("jdbc.url"));
        dataSourceBuilder.username(env.getProperty("jdbc.username"));
        dataSourceBuilder.password(env.getProperty("jdbc.password"));
        return dataSourceBuilder.build(); 
    }

	/*  JDBC Template object that we can inject into our DAOs  */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	/*  Spring MVC Dispatcher Servlet  */
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}

	/* Configure the Jersey Servlet for Spring Boot and set the URLs (e.g. /webservices/*) that it responds to  */
	// The application.properties file sets the context URL as:   server.servlet.contextPath=/zuniversity
	@Bean
	public ServletRegistrationBean<ServletContainer> jerseyServlet() {
		ServletRegistrationBean<ServletContainer> registration = new ServletRegistrationBean<ServletContainer>(
				new ServletContainer(), "/webservices/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
				JerseyRestApplicationConfig.class.getName());
		registration.setLoadOnStartup(1);
        registration.setOrder(1);
		
		registration.addUrlMappings("/webservices/*");
		return registration;
	}
	
	/*  Specify a view resolver -- in our case look in the views folder for all .jsp files  */
	/*  Note: This bean is no longer needed.  The view resolver is now configured in the application.properties file.  */
//	@Bean
//	public UrlBasedViewResolver viewResolver() {
//		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		resolver.setViewClass(JstlView.class);
//		return resolver;
//	}

}
