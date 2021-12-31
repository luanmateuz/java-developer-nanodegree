package edu.udacity.java.nano.chatroom.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.udacity.java.nano.chatroom.model.Message;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@ServerEndpoint("/chat/{username}")
public class WebSocketChatServer {

    // All Chat Sessions.
    private static final Map<String, Session> onlineSessions = new HashMap<>();

    private static void sendMessageToAll(String msg) {
        onlineSessions.forEach((username, session) -> {
            try {
                onlineSessions.get(username).getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Open Connection
    @OnOpen
    public void onOpen(Session session) {
        //TODO: add on open connection.
        Message message = new Message();
        message.setMessage(session.getPathParameters().get("username"));
        onlineSessions.put(message.getMessage(), session);
    }

    // Send Message
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        jsonObject.put("type", Message.Type.SPEAK);
        jsonObject.put("onlineCount", onlineSessions.size());
        jsonStr = jsonObject.toJSONString();

        sendMessageToAll(jsonStr);
    }

    // Close Connection
    @OnClose
    public void onClose(Session session) {
        onlineSessions.remove(session.getPathParameters().get("username"));
    }

    // Print Exception
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}
