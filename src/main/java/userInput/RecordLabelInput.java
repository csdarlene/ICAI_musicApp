package userInput;

import application.HomeInput;
import entity.RecordLabels;
import service.RecordLabelService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RecordLabelInput {
    static Scanner sc = new Scanner(System.in);
    static RecordLabelService recordLabelService = new RecordLabelService();
    public static List<RecordLabels> recordLabels = new ArrayList<>();
    static HomeInput hi = new HomeInput();

    static String menuRecordLabel = """
            1- Display All RecordLabels
            2- Add RecordLabel Details
            3- Delete RecordLabel
            4- Update RecordLabel
            5- Go back
            0- Exit""";

    public static void recordLabelMenu() {
        try {
            sc = new Scanner(System.in);

            System.out.println(menuRecordLabel);
            int opt;
            do {
                opt = sc.nextInt();
                switch (opt) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        System.out.println(recordLabelService.getAllRecordLabels());
                        System.out.println(menuRecordLabel);
                    }
                    case 2 -> {
                        insertRecordLabel();
                        System.out.println(menuRecordLabel);
                    }
                    case 3 -> {
                        deleteRecordLabel();
                        System.out.println(menuRecordLabel);
                    }
                    case 4 -> {
                        updateRecordLabel();
                        System.out.println(menuRecordLabel);
                    }
                    case 5 -> hi.maintenance();
                    default -> System.out.println("Invalid option");
                }
            } while (true);
        } catch (
                InputMismatchException e) {
            System.out.println("Invalid input");
        }

    }

    public static void insertRecordLabel() throws InputMismatchException {
        try {


            RecordLabelService recordLabelService = new RecordLabelService();
            sc = new Scanner(System.in);
            RecordLabels r = new RecordLabels();
            System.out.println("Enter Name of RecordLabel:");
            r.setName(sc.nextLine());
            recordLabelService.createRecordLabel(r);
            recordLabels.add(new RecordLabels(r.getName()));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void deleteRecordLabel() throws InputMismatchException {
        try {
            System.out.println(recordLabelService.getAllRecordLabels());
            System.out.println("Which record label do you want to delete");
            sc = new Scanner(System.in);
            Long delete = sc.nextLong();
            recordLabelService.deleteRecordLabel(delete);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void updateRecordLabel() throws InputMismatchException {
        try {
            System.out.println(recordLabelService.getAllRecordLabels());
            System.out.println("Which record label do you want to update");
            sc = new Scanner(System.in);
            Long id = sc.nextLong();
            System.out.println("What do you want to change it to");
            sc = new Scanner(System.in);
            String update = sc.nextLine();
            recordLabelService.updateRecordLabelName(id, update);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

}

