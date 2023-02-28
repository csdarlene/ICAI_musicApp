package userInput;


import application.HomeInput;
import entity.Albums;
import service.AlbumService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AlbumInput {
    static Scanner sc;
    static HomeInput hi = new HomeInput();
    static AlbumService albumService = new AlbumService();
    public static List<Albums> albums = new ArrayList<>();

    static String menuAlbum =
            "1- Display All Albums\n"+
            "2- Add Album Details\n"+
            "3- Delete Album\n"+
            "4- Update Album\n"+
            "5- Go back\n"+
            "0- Exit";

    public static void albumMenu() {
        try {
            sc = new Scanner(System.in);
            System.out.println(menuAlbum);
            int opt;
            do {
                opt = sc.nextInt();
                switch (opt) {
                    case 0 : System.exit(0);
                    case 1 : {
                        System.out.println(albumService.getAllAlbums());
                        System.out.println(menuAlbum);break;
                    }
                    case 2 : {
                        insertAlbum();
                        System.out.println(menuAlbum);break;
                    }
                    case 3 : {
                        deleteAlbum();
                        System.out.println(menuAlbum);break;
                    }
                    case 4 : {
                        updateAlbum();
                        System.out.println(menuAlbum);break;
                    }
                    case 5 : hi.maintenance();break;
                    default : System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void insertAlbum() throws InputMismatchException {
        try {
            AlbumService albumService = new AlbumService();
            sc = new Scanner(System.in);
            Albums a = new Albums();
            System.out.println("Enter Name of Album:");
            a.setName(sc.nextLine());
            System.out.println("Enter Year of release:");
            a.setYear(sc.nextInt());
            albumService.createAlbums(a);
            albums.add(new Albums(a.getName(), a.getYear()));

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void updateAlbum() throws InputMismatchException {
        try {
            System.out.println(albumService.getAllAlbums());
            System.out.println("Do you want to change the year (y)or the album name(n)?");
            sc = new Scanner(System.in);
            String choice = sc.nextLine().toLowerCase();
            if (choice.equals("y")) {
                System.out.println("Which album do you want to update");
                sc = new Scanner(System.in);
                Long id = sc.nextLong();
                System.out.println("What do you want to change it to");
                sc = new Scanner(System.in);
                Integer update = sc.nextInt();
                albumService.updateAlbumYear(id, update);
                System.out.println(menuAlbum);
            } else if (choice.equals("n")) {
                System.out.println("Which album do you want to update");
                sc = new Scanner(System.in);
                Long id = sc.nextLong();
                System.out.println("What do you want to change it to");
                sc = new Scanner(System.in);
                String update = sc.nextLine();
                albumService.updateAlbumName(id, update);
                System.out.println(menuAlbum);
            } else {
                albumMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void deleteAlbum() throws InputMismatchException {
        try {
            System.out.println(albumService.getAllAlbums());
            System.out.println("Which album do you want to delete");
            sc = new Scanner(System.in);
            Long delete = sc.nextLong();
            albumService.deleteAlbum(delete);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

}
