package service;

import configuration.JPAConfiguration;
import entity.Albums;
import repository.AlbumRepository;

import java.util.List;

public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService() {
        this.albumRepository = new AlbumRepository(JPAConfiguration.getEntityManager());
    }

    public List<Albums> getAllAlbums() {
        return albumRepository.getAllAlbums();
    }

    public void createAlbums(Albums albums) {
        albumRepository.createAlbums(albums);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteAlbum(id);
    }

    public void updateAlbumYear(Long id, Integer year) {
        albumRepository.updateAlbumYear(id, year);
    }

    public void updateAlbumName(Long id, String name) {
        albumRepository.updateAlbumName(id, name);
    }

    public Albums findAlbum(Long id) {

        return albumRepository.findAlbum(id);
    }
}



