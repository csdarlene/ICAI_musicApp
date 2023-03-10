package repository;

import entity.Playlists;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PlaylistRepository {
    private final EntityManager entityManager;

    public PlaylistRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Playlists> getAllPlaylists() {
        String query = "select pl from Playlists pl";
        TypedQuery<Playlists> typedQuery = entityManager.createQuery(query, Playlists.class);
        return typedQuery.getResultList();
    }

    public List<Playlists> getUserPlaylist(String username) {
        try {

            entityManager.getEntityManagerFactory();

            entityManager.getTransaction().begin();
            TypedQuery<Playlists> query = entityManager.createQuery("select p.name from Playlists p where p.user.username =?1", Playlists.class);
            query.setParameter(1, username);

            List<Playlists> playList = query.getResultList();
            System.out.println(playList);
            entityManager.getTransaction().commit();
            return playList;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Playlists createPlaylists(Playlists playlist) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(playlist);
            entityManager.getTransaction().commit();
            return playlist;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }

    }

    public Playlists updatePlaylistName(Long id, String name) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Playlists playlists = entityManager.find(Playlists.class, id);
        playlists.setName(name);
        System.out.println(playlists);
        entityManager.getTransaction().commit();
        return playlists;
    }

    public Playlists deletePlaylist(Long id) {
        try {
            entityManager.getEntityManagerFactory();

            entityManager.getTransaction().begin();
            Playlists playlists = entityManager.find(Playlists.class, id);
            System.out.println(playlists.getName() + " has been removed \n");
            entityManager.remove(playlists);

            entityManager.getTransaction().commit();
            return playlists;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Playlists findPlaylist(Long id) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        Playlists playlists = entityManager.find(Playlists.class, id);
        System.out.println(playlists.toString());
        entityManager.getTransaction().commit();
        return playlists;
    }

}
