package org.scrum;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;


/*
 * mvn spring-boot:run
 * mvn tomcat7:deploy -P TomcatDeployment
 * java -jar msd.t3_c9.springboot_rest_services-0.0.1-SNAPSHOT.jar --server.port=8090
 *
 * http://localhost:8088/scrum/swagger-ui/index.html
 * http://localhost:8088/scrum/v3/api-docs
 */
@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class SpringBootRESTDataServices_ScrumApplication
		extends SpringBootServletInitializer
{
	private static Logger logger = Logger.getLogger(SpringBootRESTDataServices_ScrumApplication.class.getName());
	
	public static void main(String[] args) {
		logger.info("Loading ... SpringBoot - ScrumApplication: REST DATA SECURED SERVICES ...  ");
		SpringApplication.run(SpringBootRESTDataServices_ScrumApplication.class, args);
	}
	@Bean
	public ModelMapper setupModelMapper(){
		ModelMapper mapper = new ModelMapper();
		return mapper;
	}
}