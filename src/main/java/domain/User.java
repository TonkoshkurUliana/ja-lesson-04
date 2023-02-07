package domain;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String login;

    public String getUserLogin() {
        return login;
    }

    public void setUserLogin(String login) {
        this.login = login;
    }

    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return firstName;
    }

    public void setUserFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserLastName() {
        return lastName;
    }

    public void setUserLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String password) {
        this.password = password;
    }

    public User(String login, String firstName, String lastName, String email, String password) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login=" + login +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
