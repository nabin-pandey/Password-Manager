// PasswordManager.java

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private List<Credential> credentials;
    private static final String FILE_NAME = "credentials.txt";


    public PasswordManager() {
        credentials = new ArrayList<>();
        loadCredentialsFromFile();
    }

    // Add a new credential to the list
    public void addCredential(Credential credential) {
        credentials.add(credential);
        saveCredentialToFile(credential);
    }

    // Show all stored credentials
    public void showAllCredentials() {
        if (credentials.isEmpty()) {
            System.out.println("No credentials saved.");
            return;
        }

        for (Credential c : credentials) {
            System.out.println(c);
        }
    }

    // Load credentials from the file on startup
    private void loadCredentialsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Credential c = new Credential(parts[0], parts[1], parts[2]);
                    credentials.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading credentials: " + e.getMessage());
        }
    }

    // Save new credential to file
    private void saveCredentialToFile(Credential c) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(c.toFileFormat());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving credentials: " + e.getMessage());
        }
    }
}
