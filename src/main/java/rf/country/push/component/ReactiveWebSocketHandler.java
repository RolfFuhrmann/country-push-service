package rf.country.push.component;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component("ReactiveWebSocketHandler")
public class ReactiveWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
        log.info("Reactive Web Socket Handler");

        return webSocketSession.send(Mono.just(webSocketSession.textMessage("intervalFlux")));
        // .map(webSocketSession::textMessage))
        // .and(webSocketSession.receive()
        // .map(WebSocketMessage::getPayloadAsText).log());
    }
}
