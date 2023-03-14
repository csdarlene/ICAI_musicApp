package repository;

import entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


import java.util.List;


public class UserRepository {

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Users> getAllUsers() {
        String query = "select u from Users u";
        TypedQuery<Users> typedQuery = entityManager.createQuery(query, Users.class);
        return typedQuery.getResultList();
    }

    public Users createUsers(Users users) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(users);
            entityManager.getTransaction().commit();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }

    }

    public Users findUser(Long id) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        Users users = entityManager.find(Users.class, id);
        System.out.println(users.toString());
        entityManager.getTransaction().commit();
        return users;
    }

    public Users updateUserUsername(Long id, String username) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Users users = entityManager.find(Users.class, id);
        users.setUsername(username);
        System.out.println(users);
        entityManager.getTransaction().commit();
        return users;
    }

    public Users updateUserPassword(Long id, String password) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Users users = entityManager.find(Users.class, id);
        users.setPassword(password);
        System.out.println(users);
        entityManager.getTransaction().commit();
        return users;
    }

    public Users deleteUser(Long id) {
        try {
            entityManager.getEntityManagerFactory();

            entityManager.getTransaction().begin();
            Users users = entityManager.find(Users.class, id);
            System.out.println(users.getUsername() + " has been removed \n");
            entityManager.remove(users);

            entityManager.getTransaction().commit();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }


    public List<Users> getDetailsOfUsers(String name) {
        try {

            entityManager.getEntityManagerFactory();

            entityManager.getTransaction().begin();
            TypedQuery<entity.Users> query = entityManager.createQuery("from Users u JOIN UserDetails ud ON ud.id = u.userDetails.id where u.userDetails.name =?1", entity.Users.class);
            query.setParameter(1, name);

            List<entity.Users> users = query.getResultList();
            System.out.println(users);
            entityManager.getTransaction().commit();
            entityManager.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Users signIn(String username, String password) {


            entityManager.getEntityManagerFactory();

            entityManager.getTransaction().begin();
            TypedQuery<entity.Users> query = entityManager.createQuery("from Users u where u.username =?1 AND u.password =?2", entity.Users.class);
            query.setParameter(1, username);
            query.setParameter(2, password);

            Users users = query.getSingleResult();
            System.out.println(users);
            entityManager.getTransaction().commit();
            entityManager.close();
            return users;
    }

}

