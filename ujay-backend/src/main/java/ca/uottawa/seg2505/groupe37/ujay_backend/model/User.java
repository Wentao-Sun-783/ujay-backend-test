
package ca.uottawa.seg2505.groupe37.ujay_backend.model;

public class User {

    private String username;
    private String password;
    private String phoneNumber;
    private Role role;

    public User(String username, String password,
                String phoneNumber, Role role) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }
}
