package userInput;

import application.HomeInput;
import entity.Playlists;
import entity.Users;
import service.PlaylistService;
import service.UserService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PlaylistInput {
    static Scanner sc;
    static PlaylistService playlistService = new PlaylistService();
    static HomeInput hi = new HomeInput();
    public static List<Playlists> playlists = new ArrayList<>();

    static String menuPlaylist = "1- Display All Playlists\n"+
            "2- Add Playlist Details\n"+
            "3- Delete Playlist\n"+
            "4- Update Playlist\n"+
            "5- Go back\n"+
            "0- Exit";

    public static void playlistMenu() {
        try {
            sc = new Scanner(System.in);

            System.out.println(menuPlaylist);
            int opt;
            do {
                opt = sc.nextInt();
                switch (opt) {
                    case 0 : System.exit(0);
                    case 1 : {
                        System.out.println(playlistService.getAllPlaylists());
                        System.out.println(menuPlaylist);break;
                    }
                    case 2 : {
                        insertPlaylist();
                        System.out.println(menuPlaylist);break;
                    }
                    case 3 : {
                        deletePlaylist();
                        System.out.println(menuPlaylist);break;
                    }
                    case 4 : {
                        updatePlaylist();
                        System.out.println(menuPlaylist);break;
                    }
                    case 5 : hi.maintenance();break;
                    default : System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void selectPlaylist() {
        System.out.println("Please enter playlist name:");
        sc = new Scanner(System.in);
        String playlist = sc.nextLine();
        PlaylistService playlistService = new PlaylistService();
        for (Playlists p : playlistService.getAllPlaylists()) {
            if (p.getName().equals(playlist)) {
                System.out.println(p.getSongSet());
            }
        }
    }

    public static void insertPlaylist() throws InputMismatchException {
        try {
            PlaylistService PlaylistService = new PlaylistService();
            sc = new Scanner(System.in);
            Playlists p = new Playlists();
            System.out.println("Enter Name of Playlist:");
            p.setName(sc.nextLine());
            System.out.println("Enter Name of User:");
            sc = new Scanner(System.in);
            String username = sc.nextLine().toLowerCase();
            UserService userService = new UserService();

            for (Users us : userService.getAllUsers()) {
                if ((us.getUsername().toLowerCase()).equals(username)) {
                    Long id = us.getId();
                    p.setUserID(userService.findUser(id));
                    PlaylistService.createPlaylists(p);
                    playlists.add(new Playlists(p.getName(), p.getUserID()));
                    return;
                }
            }
            System.out.println("Could not insert the Playlist \n");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void deletePlaylist() throws InputMismatchException {
        try {
            System.out.println(playlistService.getAllPlaylists());
            System.out.println("Which playlist do you want to delete");
            sc = new Scanner(System.in);
            Long delete = sc.nextLong();
            playlistService.deletePlaylist(delete);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void updatePlaylist() throws InputMismatchException {
        try {
            System.out.println(playlistService.getAllPlaylists());
            System.out.println("Which playlist do you want to update");
            sc = new Scanner(System.in);
            Long id = sc.nextLong();
            System.out.println("What do you want to change it to");
            sc = new Scanner(System.in);
            String update = sc.nextLine();
            playlistService.updatePlaylistName(id, update);
            System.out.println(menuPlaylist);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

}

