package rf.country.push.controller;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import jakarta.websocket.EncodeException;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import rf.country.push.model.Country;
import rf.country.push.model.CountryDecoder;
import rf.country.push.model.CountryEncoder;

@Slf4j
@ServerEndpoint(value = "/websocket", decoders = CountryDecoder.class, encoders = CountryEncoder.class)
public class WebSocketController {

    private Session session;
    private static Set<WebSocketController> reactiveWebSocketendpoints = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig) throws IOException {
        // Get session and WebSocket connection
        this.session = session;
        session.setMaxIdleTimeout(0);
        reactiveWebSocketendpoints.add(this);
        log.info("Get session and WebSocket connection");
    }

    @OnMessage
    public void onMessage(Country country, Session session) throws IOException {
        // Handle new messages
        log.info("Handle new messages -> {}", country);
        broadcast(country);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        reactiveWebSocketendpoints.remove(this);
        log.info("WebSocket connection closes");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.info("Do error handling here -> {}", throwable.getMessage());
        throwable.printStackTrace();
    }

    public static void broadcast(Country country) {

        reactiveWebSocketendpoints.forEach(endpoint -> {
            try {
                endpoint.session.getBasicRemote().sendObject(country);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }
}
