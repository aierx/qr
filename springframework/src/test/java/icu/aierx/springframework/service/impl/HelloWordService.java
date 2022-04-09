package icu.aierx.springframework.service.impl;

import icu.aierx.springframework.service.IHelloWorldService;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class HelloWordService implements IHelloWorldService {

    private String username;


    private String password;


    @Override
    @Deprecated
    public void helloWord() {
        System.out.println(username);
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
}
