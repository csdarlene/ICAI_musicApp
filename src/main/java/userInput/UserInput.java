package userInput;

import application.HomeInput;
import entity.Users;
import service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    static Scanner sc;
    static UserService userService = new UserService();
    static HomeInput hi = new HomeInput();
    static String menuUser = "1- Display All Users\n"+
            "2- Add User Details\n"+
            "3- Delete User\n"+
            "4- Update User\n"+
            "5- Go back\n"+
            "0- Exit";

    public static void userMenu() {
        try {
            sc = new Scanner(System.in);
            System.out.println(menuUser);
            int opt;
            do {
                opt = sc.nextInt();
                switch (opt) {
                    case 0 : System.exit(0);
                    case 1 : {
                        System.out.println(userService.getAllUsers());
                        System.out.println(menuUser);break;
                    }
                    case 2 : {
                        hi.createUser();
                        System.out.println(menuUser);break;
                    }
                    case 3 : {
                        deleteUser();
                        System.out.println(menuUser);break;
                    }
                    case 4 : updateUserByAdmin();break;
                    case 5 : hi.maintenance();break;
                    default : System.out.println("Invalid option");
                }
            } while (true);
        } catch (
                InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void deleteUser() throws InputMismatchException {
        try {
            System.out.println(userService.getAllUsers());
            System.out.println("Which user do you want to delete");
            sc = new Scanner(System.in);
            Long delete = sc.nextLong();
            userService.deleteUser(delete);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void updateUserByAdmin() throws InputMismatchException {
        try {
            System.out.println(userService.getAllUsers());
            System.out.println("Do you want the username (u) or the password(p)?");
            sc = new Scanner(System.in);
            String choice = sc.nextLine().toLowerCase();
            if (choice.equals("u")) {
                System.out.println("Which username do you want to update");
                sc = new Scanner(System.in);
                Long id = sc.nextLong();
                System.out.println("What do you want to change it to");
                sc = new Scanner(System.in);
                String update = sc.nextLine();
                userService.updateUserUsername(id, update);
                System.out.println(menuUser);
            } else if (choice.equals("p")) {
                System.out.println("Which password do you want to update");
                sc = new Scanner(System.in);
                Long id = sc.nextLong();
                System.out.println("What do you want to change it to");
                sc = new Scanner(System.in);
                String update = sc.nextLine();
                userService.updateUserPassword(id, update);
                System.out.println(menuUser);
            } else {
                userMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void updateUserByUser() throws InputMismatchException {
        try {
            System.out.println("Do you want to change your username (u) or your password (p)?");
            sc = new Scanner(System.in);
            Long id;
            String choice = sc.nextLine().toLowerCase();
            if (choice.equals("u")) {
                System.out.println("Old username");
                sc = new Scanner(System.in);
                String username = sc.nextLine().toLowerCase();

                for (Users users : userService.getAllUsers()) {
                    if ((users.getUsername().toLowerCase()).equals(username)) {
                        id = users.getId();
                        System.out.println("Change username");
                        sc = new Scanner(System.in);
                        String update = sc.nextLine().toLowerCase();
                        userService.updateUserUsername(id, update);
                        return;
                    }
                }
            } else if (choice.equals("p")) {
                System.out.println("Old password");
                sc = new Scanner(System.in);
                String password = sc.nextLine();
                for (Users users : userService.getAllUsers()) {
                    if ((users.getPassword()).equals(password)) {
                        id = users.getId();
                        System.out.println("Change password");
                        sc = new Scanner(System.in);
                        String update = sc.nextLine();
                        userService.updateUserPassword(id, update);
                        return;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }
}
