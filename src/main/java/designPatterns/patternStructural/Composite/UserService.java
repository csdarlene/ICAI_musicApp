package designPatterns.patternStructural.Composite;

import entity.Songs;

public class UserService implements ServiceStructural {
private Songs songs;

    public UserService( Songs songs ) {this.songs=songs;
    }

    @Override
    public void service(String serviceType) {
        System.out.println(serviceType+" by User");
    }

    @Override
    public Double getLength() {
        return songs.getTime();
    }
}
