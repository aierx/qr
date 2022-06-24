package aaa.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leiwenyong
 * @since 2022-05-16
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user = new User(11111L, 33333L);
        ThreadLocal<User> local = new ThreadLocal<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.submit(new run(local,i));
        }
        Thread.sleep(1000);
        local = null;
    }
}


class run implements Runnable{
    ThreadLocal<User> local ;
    long i;

    public run(ThreadLocal<User> local,long i) {
        this.local = local;
        this.i = i;
    }

    @Override
    public void run() {
        User user = new User(10000L,i);
        local.set(user);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User s = local.get();
        System.out.println(s);
    }

}


class User {
    private Long username;
    private Long password;

    public User(Long username, Long password) {
        this.username = username;
        this.password = password;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
