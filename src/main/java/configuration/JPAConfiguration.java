package configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class JPAConfiguration {

    private static final String PERSISTENCE_UNIT_NAME = "unasat_persistence";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private static EntityManager entityManager = factory.createEntityManager();

    public static EntityManager getEntityManager() {
        return entityManager;
    }


    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); {

            try {
                SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            }catch(Exception e){
                StandardServiceRegistryBuilder.destroy(registry);

            }
        }
    }
}
