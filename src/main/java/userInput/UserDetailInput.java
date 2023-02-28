package userInput;

import application.HomeInput;
import service.UserDetailService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDetailInput {

    static Scanner sc;
    static HomeInput hi = new HomeInput();
    static UserDetailService userDetailService = new UserDetailService();
    static String menuUserDetail = """
            1- Display All UserDetails
            2- Add User details
            3- Delete UserDetail
            4- Update UserDetail
            5- Go back0- Exit""";

    public static void userDetailMenu() {
        try {
            sc = new Scanner(System.in);
            System.out.println(menuUserDetail);
            int opt;
            do {
                opt = sc.nextInt();
                switch (opt) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        System.out.println(userDetailService.getAllUserDetails());
                        System.out.println(menuUserDetail);
                    }
                    case 2 -> {
                        hi.createUserDetail();
                        System.out.println(menuUserDetail);
                    }
                    case 3 -> {
                        deleteUser();
                        System.out.println(menuUserDetail);
                    }
                    case 4 -> {
                        updateUser();
                        System.out.println(menuUserDetail);
                    }
                    case 5 -> hi.maintenance();
                    default -> System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void deleteUser() throws InputMismatchException {
        try {
            System.out.println(userDetailService.getAllUserDetails());
            System.out.println("Which userdetail do you want to delete");
            sc = new Scanner(System.in);
            Long delete = sc.nextLong();
            userDetailService.deleteUserDetail(delete);

        }
    catch (InputMismatchException e) {
        System.out.println("Invalid input");
    }}

    public static void updateUser() throws InputMismatchException {
        try {          System.out.println(userDetailService.getAllUserDetails());
            System.out.println("Do you want to change the name (n)or the mail address(m)?");
            sc = new Scanner(System.in);
            String choice = sc.nextLine().toLowerCase();
            if (choice.equals("n")) {
                System.out.println("Which name do you want to update");
                sc = new Scanner(System.in);
                Long id = sc.nextLong();
                System.out.println("What do you want to change it to");
                sc = new Scanner(System.in);
                String update1 = sc.nextLine();
                userDetailService.updateUserDetailName(id, update1);
                System.out.println(menuUserDetail);

            } else if (choice.equals("m")) {
                System.out.println("Which mail do you want to update");
                sc = new Scanner(System.in);
                Long id = sc.nextLong();
                System.out.println("What do you want to change it to");
                sc = new Scanner(System.in);
                String update2 = sc.nextLine();
                userDetailService.updateUserDetailEmail(id, update2);
                System.out.println(menuUserDetail);
            } else {
                userDetailMenu();
            }

        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }}
}
