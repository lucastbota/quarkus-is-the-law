package tech.donau.course;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat/{username}")
@ApplicationScoped
public class ChatConfiguration {

    private final Map<String, Session> chatMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        chatMap.put(username, session);
        sendMessage(String.format("User %s loggedin", username));
    }

    @OnMessage
    public void onMessage(String message, @PathParam("username") String username) {
        sendMessage(String.format(">> %s: %s", username, message));
    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        chatMap.remove(username);
        sendMessage(String.format("User %s logged out", username));
    }

    @OnError
    public void onError(Session session, @PathParam("username") String username, Throwable throwable) {
        chatMap.remove(username);
        throwable.printStackTrace();
        sendMessage(String.format("User %s logged out due to an error.", username));
    }

    public void sendMessage(String message) {
        chatMap.values().forEach(it ->
                it.getAsyncRemote().sendObject(message, r -> {
                    if (r.getException() != null) {
                        r.getException().printStackTrace();
                    }
                })
        );
    }
}
