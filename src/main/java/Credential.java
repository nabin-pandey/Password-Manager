
public class Credential {
    private String website;
    private String username;
    private String password;

    // Constructor
    public Credential(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Format for saving to file
    public String toFileFormat() {
        return website + "," + username + "," + password;
    }

    // Format for displaying to user
    @Override
    public String toString() {
        return "Website: " + website + ", Username: " + username + ", Password: " + password;
    }
}
