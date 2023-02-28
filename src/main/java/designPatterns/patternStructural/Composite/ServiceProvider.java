package designPatterns.patternStructural.Composite;


import java.util.ArrayList;
import java.util.List;

public class ServiceProvider implements ServiceStructural {
    private Double totalLength;

    private List<ServiceStructural> songList = new ArrayList<>();


    public ServiceProvider() {
    }


    @Override
    public void service( String serviceType ) {
        for (ServiceStructural serviceStructural : songList) {
            serviceStructural.service(serviceType);
        }
    }

    @Override
    public Double getLength() {
        totalLength=0.0;
        for (ServiceStructural s: songList){
            totalLength=totalLength+ s.getLength();
        }
        return totalLength;
    }

    public void addSong( ServiceStructural serviceStructural ) {
        songList.add(serviceStructural);
    }

    public void deleteSong( ServiceStructural serviceStructural ) {
        songList.remove(serviceStructural);
    }

    public void clearServices() {
        songList.clear();
    }
}
