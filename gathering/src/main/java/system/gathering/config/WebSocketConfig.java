package system.gathering.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import system.gathering.handler.SocketHandler;
import system.gathering.handler.SocketHandler2;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    SocketHandler socketHandler;

    @Autowired
    SocketHandler2 socketHandler2;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(socketHandler, "/chating/{roomNumber}"/*,"/ltforum/chating/{roomNumber}"*/)
                        .addInterceptors(new HttpSessionHandshakeInterceptor());
        registry.addHandler(socketHandler2,"/ltforum/chating/{roomNumber}");
    }
}
