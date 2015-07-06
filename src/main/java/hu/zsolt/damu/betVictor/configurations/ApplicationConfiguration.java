package hu.zsolt.damu.betVictor.configurations;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

import javax.servlet.MultipartConfigElement;
import java.nio.charset.Charset;

/**
 * Created by TamasZsolt on 30/06/2015.
 */

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("2048MB");
        factory.setMaxRequestSize("2048MB");

        return factory.createMultipartConfig();
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
}
