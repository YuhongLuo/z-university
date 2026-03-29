package edu.npu.zu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import edu.npu.zu.config.UnivAppConfig;

@SpringBootApplication
@Import(UnivAppConfig.class)
@ComponentScan(basePackages = {
        "edu.npu.zu.controllers",
        "edu.npu.zu.resthandlers",
        "edu.npu.zu.dao",
        "edu.npu.zu.services",
        })
public class ZuniversityApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ZuniversityApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ZuniversityApplication.class, args);
	}
}
