// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordManager manager = new PasswordManager();

        while (true) {
            System.out.println("\n=== Password Manager ===");
            System.out.println("1. Add New Credential");
            System.out.println("2. View All Credentials");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Website: ");
                    String website = sc.nextLine();

                    System.out.print("Username: ");
                    String username = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    Credential c = new Credential(website, username, password);
                    manager.addCredential(c);
                    System.out.println("✅ Credential saved.");
                    break;

                case "2":
                    System.out.println("🔐 Saved Credentials:");
                    manager.showAllCredentials();
                    break;

                case "3":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
