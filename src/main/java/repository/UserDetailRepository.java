package repository;

import entity.UserDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserDetailRepository {

    private final EntityManager entityManager;

    public UserDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<UserDetails> getAllUserDetails() {
        String query = "select ud from UserDetails ud";
        TypedQuery<UserDetails> typedQuery = entityManager.createQuery(query, UserDetails.class);
        return typedQuery.getResultList();
    }

    public UserDetails createUserDetails(UserDetails userDetails) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userDetails);
            entityManager.getTransaction().commit();
            return userDetails;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }

    }

    public void updateUserDetailName(Long id, String name) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        UserDetails userDetails = entityManager.find(UserDetails.class, id);
        userDetails.setName(name);
        System.out.println(userDetails);
        entityManager.getTransaction().commit();

    }

    public UserDetails deleteUserDetail(Long id) {
        try {
            entityManager.getEntityManagerFactory();

            entityManager.getTransaction().begin();
            UserDetails userDetails = entityManager.find(UserDetails.class, id);
            System.out.println(userDetails.getName() + " has been removed \n");
            entityManager.remove(userDetails);

            entityManager.getTransaction().commit();
            return userDetails;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public void updateUserDetailEmail(Long id, String mail) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        UserDetails userDetails = entityManager.find(UserDetails.class, id);
        userDetails.setEmail(mail);
        System.out.println(userDetails);
        entityManager.getTransaction().commit();

    }
}
