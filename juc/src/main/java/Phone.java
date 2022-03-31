import java.util.concurrent.TimeUnit;

public class Phone {

    public synchronized void sendMsg(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    public static synchronized void email(){
        System.out.println("发邮件");
    }
}
