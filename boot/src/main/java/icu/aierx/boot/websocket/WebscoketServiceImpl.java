package icu.aierx.boot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description: webScoket业务类
 * @author: Tianmingcong
 * @since: 2021-11-26 11:09
 **/
@ServerEndpoint(value = "/webscoket/{userUuid}")
@Component
@Slf4j
public class WebscoketServiceImpl {
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebscoketServiceImpl that = (WebscoketServiceImpl) o;
        return Objects.equals(session, that.session) && Objects.equals(userUuid, that.userUuid);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(session, userUuid);
    }
    
    /**
     * volatile 每次取这个变量的值都需要从主存中取,而不是用自己线程工作内存中的缓存.
     */
    private static volatile int  onlineCount = 0 ;

    /**
     * 使用线程安全的集合，避免多线程下竞争问题
     */
    private static final CopyOnWriteArraySet<WebscoketServiceImpl> webscoketSet = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 用户唯一标识 用于指定向某个用户发送消息
     */
    private String userUuid ;

    /**
     * 主要作用也是用来做唯一标识，指定发送给单个或多个对象  ,相当于  webscoketSet 和 session
     * @param session
     * @param userUuid
     */
//    private static ConcurrentHashMap<String,Session> webscoketMap = new ConcurrentHashMap<>();


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userUuid") String userUuid ) {
        this.session = session;
        this.userUuid = userUuid;
        webscoketSet.add(this);
        //在线数加1
        addOnlineCount();
        new Thread(()->{
            try {
                int i = 100;
                while (true){
                    Thread.sleep(1000);
                    this.sendMessage("hello" + i);
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void OnClose(Session session , @PathParam("userUuid") String userUuid ) {
        webscoketSet.remove(this);
        //在线数减1
        subOnlineCount();
    }

    /**
     * 接收到客户端消息触发，可用于处理客户端发送的消息，数据处理或者入库
     * @param message
     * @param session
     * @param userUuid
     */
    @OnMessage
    public void onMessage(String message,Session session, @PathParam("userUuid") String userUuid) {
        // 这里是向所有用户发送某个客服端发送的消息   客户端发送什么这里返回什么   这是演示并未处理
        for (WebscoketServiceImpl item : webscoketSet){
            try {
                log.warn(message);
                item.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 连接异常
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.getStackTrace();
    }

    /**
     * websocket  session发送文本消息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        // 同步发送
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息    后端发送消息调用
     */
    public static void sendInfo(String message,@PathParam("userUuid") String userUuid)  {
        for (WebscoketServiceImpl item : webscoketSet){
            try {
                if(null == userUuid){
                    item.sendMessage(message);
                }else if(item.userUuid.equals(userUuid)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消息广播-发送给所有在线用户     后端发送消息调用
     *
     * @param message
     */
    public static void sendInfoToAll(String message) {
        for (WebscoketServiceImpl item : webscoketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebscoketServiceImpl.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebscoketServiceImpl.onlineCount--;
    }

}