package application;

import entity.Songs;
import service.PlaylistService;
import service.SongService;

import java.util.Scanner;

public class Application {

    //        Step 1
//         Dummy Data
    public void dummyData()
    {Data data = new Data();
        PlaylistService playlistService = new PlaylistService();
        data.infromation();
        playlistService.getUserPlaylist("darlene111");    //  insert Many To many Dummy Data
    }

    //Step 2
    // Applicatie
    public void begin() {
        HomeInput HI = new HomeInput();
        HI.frontPage();
    }

    //        Step 3
//         Play all the song in database
    public void playMusic() {
        SongService songService = new SongService();
        for (Songs songs : songService.getAllSongs()) {
            PlayMusic playlist = new PlayMusic();

            playlist.Play(songs.getName());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Next song");
            String next = scanner.nextLine();
        }
        System.out.println("Done");


    }
}


