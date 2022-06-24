package icu.aierx;

/**
 * @author leiwenyong
 * @since 2022-05-15
 */

public class Account  extends AccountSuper {

    private static final long serialVersionUID = 678543915964486627L;

    private String username;

    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
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
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", father='" + father + '\'' +
                '}';
    }
}
