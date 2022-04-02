package icu.aierx.mybatis;

/**
 * @author leiwenyong
 * @since 2022/4/2
 */
public class User {
    private String userId;

    private String userAge;

    private String userName;

    private String userPassword;

    public User() {
    }

    public User(String userId, String userAge, String userName, String userPassword) {
        this.userId = userId;
        this.userAge = userAge;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
