package bookstore.com.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotEmpty(message = "Username must be not empty")
    @Size(min = 1, max = 50, message = "Value must be between 1 and 50")
    private String username;
    @NotEmpty(message = "Password must be not empty")
    @Size(min = 1, max = 50, message = "Value must be between 1 and 50")
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
