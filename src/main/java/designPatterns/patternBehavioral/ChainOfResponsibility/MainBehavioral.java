package designPatterns.patternBehavioral.ChainOfResponsibility;

import java.util.Scanner;

public class MainBehavioral {

    public static void MainBehaviora() {
        final String artist;
        final String song;
        Scanner scanner;

        System.out.println("Please enter song name:");
        scanner = new Scanner(System.in);
        song = scanner.nextLine();

        System.out.println("Please enter artist name:");
        scanner = new Scanner(System.in);
        artist = scanner.nextLine();

        linkSongToArtist(artist, song);
    }
        public static void linkSongToArtist ( String artist, String song) {

        try {


                Handler handler = new UserExistHandler();
                handler.setNextHandler(new ArtistExistHandler()).setNextHandler(new RecordLabelExistHandler());

                ServiceBehavioral service = new ServiceBehavioral(handler);

                System.out.println(service.SongArtist(artist, song));

//        System.out.println(service.SongArtist("Post Malone","I Like You (A Happier Song)"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


