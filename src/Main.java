import service.UserService;
import model.User;

import java.util.Scanner;

public class Main {
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. View User by ID");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    userService.addUser(name, email, phone, password);
                    break;

                case 2:
                    for (User user : userService.listUsers()) {
                        System.out.println(user);
                    }
                    break;

                case 3:
                    System.out.print("Enter user ID: ");
                    int id = scanner.nextInt();
                    System.out.println(userService.findUser(id));
                    break;

                case 4:
                    System.out.print("Enter user ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();

                    userService.modifyUser(updateId, newName, newEmail, newPhone, newPassword);
                    break;

                case 5:
                    System.out.print("Enter user ID to delete: ");
                    int deleteId = scanner.nextInt();
                    userService.removeUser(deleteId);
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
