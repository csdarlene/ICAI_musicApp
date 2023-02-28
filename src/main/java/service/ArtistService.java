package service;

import configuration.JPAConfiguration;
import entity.Artists;
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

    public void createArtist( Artists artist ) {
        artistRepository.createArtists(artist);
    }

    public Artists findArtist(Long id)
    {
        return artistRepository.findArtist(id);
    }

    public void updateArtistName( Long id, String name){
        artistRepository.updateArtistName(id, name);
    }

    public void deleteArtist( Long id){
        artistRepository.deleteArtist(id);
    }


}

