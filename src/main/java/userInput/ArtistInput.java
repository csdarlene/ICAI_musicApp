package userInput;

import application.HomeInput;
import entity.Artists;
import entity.RecordLabels;
import service.ArtistService;
import service.RecordLabelService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArtistInput {

    static Scanner sc = new Scanner(System.in);
    static Artists a = new Artists();
    static ArtistService artistService = new ArtistService();
    static HomeInput hi = new HomeInput();

    public static List<Artists> artists = new ArrayList<>();

    static String menuArtist = """
            1- Display All Artists
            2- Add Artist Details
            3- Delete Artist
            4- Update Artist
            5- Go back
            0- Exit""";

    public static void artistMenu() {
        try {
            sc = new Scanner(System.in);

            System.out.println(menuArtist);
            int opt;
            do {
                opt = sc.nextInt();
                switch (opt) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        System.out.println(artistService.getAllArtists());
                        System.out.println(menuArtist);
                    }
                    case 2 -> {
                        insertArtist();
                        System.out.println(menuArtist);
                    }
                    case 3 -> {
                        deleteArtist();
                        System.out.println(menuArtist);
                    }
                    case 4 -> {
                        updateArtist();
                        System.out.println(menuArtist);
                    }
                    case 5 -> hi.maintenance();
                    default -> System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void insertArtist() throws InputMismatchException {
        try {
            sc = new Scanner(System.in);

            System.out.println("Enter Name of Artist:");
            a.setName(sc.nextLine());
            System.out.println("Enter Record Label:");
            Scanner scan = new Scanner(System.in);
            String recordLabel = scan.nextLine().toLowerCase();
            RecordLabelService recordLabelService = new RecordLabelService();

            for (RecordLabels rl : recordLabelService.getAllRecordLabels()) {
                if ((rl.getName().toLowerCase()).equals(recordLabel)) {
                    Long id = rl.getId();
                    a.setRecordLabelID(recordLabelService.findRecordLabel(id));
                    artistService.createArtist(a);
                    artists.add(new Artists(a.getName(), a.getRecordLabelID()));
                    return;
                }
            }
            System.out.println("Could not insert the Artist\n");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void deleteArtist() throws InputMismatchException {
        try {
            System.out.println(artistService.getAllArtists());
            System.out.println("Which artist do you want to delete");
            sc = new Scanner(System.in);
            Long delete = sc.nextLong();
            artistService.deleteArtist(delete);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void updateArtist() throws InputMismatchException {
        try {
            System.out.println(artistService.getAllArtists());
            System.out.println("Which artist do you want to update");
            sc = new Scanner(System.in);
            Long id = sc.nextLong();
            System.out.println("What do you want to change it to");
            sc = new Scanner(System.in);
            String update = sc.nextLine();
            artistService.updateArtistName(id, update);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }
}
