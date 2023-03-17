package repository;

import entity.Artists;
import entity.Songs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ArtistRepository {
    private final EntityManager entityManager;

    public ArtistRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Artists> getAllArtists() {
        String query = "select ar from Artists ar";
        TypedQuery<Artists> typedQuery = entityManager.createQuery(query, Artists.class);
        return typedQuery.getResultList();
    }

    public Artists createArtists(Artists artist) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(artist);
            entityManager.getTransaction().commit();
            return artist;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }

    }

    public Artists findArtist(Long id) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        Artists artists = entityManager.find(Artists.class, id);
        System.out.println(artists.toString());
        entityManager.getTransaction().commit();
        return artists;
    }

    public Artists deleteArtist(Long id) {
        try {
            entityManager.getEntityManagerFactory();

            entityManager.getTransaction().begin();
            Artists artists = entityManager.find(Artists.class, id);
            System.out.println(artists.getName() + " has been removed \n");
            entityManager.remove(artists);

            entityManager.getTransaction().commit();
            return artists;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Artists updateArtistName(Long id, String name) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Artists artists = entityManager.find(Artists.class, id);
        artists.setName(name);
        System.out.println(artists);
        entityManager.getTransaction().commit();
        return artists;
    }
    public List<Artists> getArtistAlbum(String artists) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        TypedQuery<Artists> query = entityManager.createQuery("select a.albumSet from Artists a where a.name =?1", Artists.class);

        query.setParameter(1, artists);

        List<Artists> artist = query.getResultList();
        System.out.println(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
        return artist;
    }

}
