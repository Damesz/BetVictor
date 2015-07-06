package hu.zsolt.damu.betVictor.configurations;

import hu.zsolt.damu.betVictor.service.SavedObjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by TamasZsolt on 30/06/2015.
 */

@Configuration
public class ServiceConfiguration {

    @Bean
    public SavedObjectService getSavedObjectService() throws IOException {
        return new SavedObjectService();
    }
}
