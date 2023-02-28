package designPatterns.patternStructural.Composite;


import entity.Songs;

public class AdminService implements ServiceStructural {
    private Songs songs;

    public AdminService( Songs songs ) {
        super();
        this.songs = songs;
    }

    public AdminService() {
    }

    @Override
    public void service(String serviceType) {
        System.out.println(serviceType+ " by Admin");
    }

    @Override
    public Double getLength() {
        return songs.getTime();
    }
}