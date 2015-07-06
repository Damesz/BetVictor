package hu.zsolt.damu.betVictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * Created by TamasZsolt on 30/06/2015.
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource({"classpath:META-INF/spring/spring-context.xml"})
public class Runner extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Runner.class);
    }

    public static void main(final String[] args) { SpringApplication.run(Runner.class, args); }
}
