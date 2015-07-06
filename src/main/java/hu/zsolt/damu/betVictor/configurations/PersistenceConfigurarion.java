package hu.zsolt.damu.betVictor.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by TamasZsolt on 30/06/2015.
 */

@Configuration
public class PersistenceConfigurarion {

    @Value("${persistence.unit.name:betVictor-jpaData}")
    private String persistenceUnitName;

    @Bean
    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        return entityManagerFactory.createEntityManager();
    }
}
