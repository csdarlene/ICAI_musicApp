package service;

import configuration.JPAConfiguration;
import entity.Artists;
import entity.Songs;
import repository.ArtistRepository;

import java.util.List;

public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService() {
        this.artistRepository = new ArtistRepository(JPAConfiguration.getEntityManager());
    }

    public List<Artists> getAllArtists() {
        return artistRepository.getAllArtists();
    }

    public Artists createArtist(Artists artist) {
        return artistRepository.createArtists(artist);
    }

    public Artists findArtist(Long id) {
        return artistRepository.findArtist(id);
    }

    public Artists updateArtistName(Long id, String name) {
        return artistRepository.updateArtistName(id, name);
    }

    public Artists deleteArtist(Long id) {
        return artistRepository.deleteArtist(id);
    }

    public List<Artists> getArtistAlbum(String artist) {
        return artistRepository.getArtistAlbum(artist);

    }

}

