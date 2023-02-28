package userInput;

import application.HomeInput;
import designPatterns.patternBehavioral.ChainOfResponsibility.MainBehavioral;
import entity.Albums;
import entity.Songs;
import service.AlbumService;
import service.SongService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SongInput {
    static Scanner sc;
    public static List<Songs> songs = new ArrayList<>();
    static SongService songService = new SongService();
    static HomeInput hi = new HomeInput();
    static String menuSong = """
            1- Display All Songs
            2- Add Song Details
            3- Delete Song
            4- Update Song
            5- Go back
            0- Exit""";

    public static void songMenu() {
        try {
            sc = new Scanner(System.in);
            System.out.println(menuSong);
            int opt;
            do {
                opt = sc.nextInt();
                switch (opt) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        System.out.println(songService.getAllSongs());
                        System.out.println(menuSong);
                    }
                    case 2 -> {
                        insertSong();
                        System.out.println(menuSong);
                    }
                    case 3 -> {
                        deleteSong();
                        System.out.println(menuSong);
                    }
                    case 4 -> {
                        updateSong();
                        System.out.println(menuSong);
                    }
                    case 5 -> hi.maintenance();
                    default -> System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void insertSong() throws InputMismatchException {
        try {
            SongService songService = new SongService();
            AlbumService albumService = new AlbumService();
            sc = new Scanner(System.in);
            Songs s = new Songs();
            System.out.println("Enter Name of Song:");
            s.setName(sc.nextLine());
            String song = s.getName();
            System.out.println("Enter length of song:");
            s.setTime(sc.nextDouble());
            System.out.println("Enter name of Album:");
            Scanner scan = new Scanner(System.in);
            String album = scan.nextLine().toLowerCase();

            for (Albums album1 : albumService.getAllAlbums()) {
                if ((album1.getName().toLowerCase()).equals(album)) {
                    Long id = album1.getId();
                    s.setAlbumID(albumService.findAlbum(id));
                    songService.createSongs(s);
                    songs.add(new Songs(s.getName(), s.getTime(), s.getAlbumID()));

                    String artist;
                    System.out.println("Please enter artist name:");
                    sc = new Scanner(System.in);
                    artist = sc.nextLine();
                    MainBehavioral.linkSongToArtist(artist, song);
                    return;
                }
            }
            System.out.println("Could not insert the Song\n");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }

    }

    public static void updateSong() throws InputMismatchException {
        try {
            System.out.println(songService.getAllSongs());
            System.out.println("Which song do you want to update");
            sc = new Scanner(System.in);
            Long id = sc.nextLong();
            System.out.println("What do you want to change it to");
            sc = new Scanner(System.in);
            String update = sc.nextLine();
            songService.updateSongName(id, update);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void deleteSong() throws InputMismatchException {
        try {
            System.out.println(songService.getAllSongs());
            System.out.println("Which song do you want to delete");
            sc = new Scanner(System.in);
            Long delete = sc.nextLong();
            songService.deleteSong(delete);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }
}