package repository;

import entity.Albums;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AlbumRepository {
    private final EntityManager entityManager;

    public AlbumRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Albums> getAllAlbums() {
        String query = "select al from Albums al";
        TypedQuery<Albums> typedQuery = entityManager.createQuery(query, Albums.class);
        return typedQuery.getResultList();
    }


    public Albums findAlbum(Long id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unasat_persistence");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Albums albums = entityManager.find(Albums.class, id);
        System.out.println(albums.toString());
        entityManager.getTransaction().commit();
        return albums;
    }

    public void updateAlbumName(Long id, String name) {
        entityManager.getEntityManagerFactory();
        entityManager.getTransaction().begin();

        Albums albums = entityManager.find(Albums.class, id);
        albums.setName(name);
        System.out.println(albums);
        entityManager.getTransaction().commit();

    }

    public Albums deleteAlbum(Long id) {
        entityManager.getEntityManagerFactory();

        try {
            entityManager.getTransaction().begin();
            Albums albums = entityManager.find(Albums.class, id);
            System.out.println(albums.getName() + " has been removed \n");
            entityManager.remove(albums);
            entityManager.getTransaction().commit();
            return albums;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Albums createAlbums(Albums album) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(album);
            entityManager.getTransaction().commit();
            return album;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public void updateAlbumYear(Long id, Integer year) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Albums albums = entityManager.find(Albums.class, id);
        albums.setYear(year);
        System.out.println(albums);
        entityManager.getTransaction().commit();

    }

}