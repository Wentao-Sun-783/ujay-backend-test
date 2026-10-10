package ca.uottawa.seg2505.groupe37.ujay_backend.model;

public class AdminCreateModeratorRequest {

    private String adminUsername;
    private String adminPassword;

    private String username;
    private String password;
    private String phoneNumber;

    public AdminCreateModeratorRequest() {
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}