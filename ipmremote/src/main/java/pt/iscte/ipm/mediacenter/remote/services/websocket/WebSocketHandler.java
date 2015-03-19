package pt.iscte.ipm.mediacenter.remote.services.websocket;

import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import pt.iscte.ipm.mediacenter.core.events.ConnectEvent;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventIncomingWrapper;
import pt.iscte.ipm.mediacenter.core.events.EventOutgoingWrapper;

import java.io.IOException;

public class WebSocketHandler implements WebSocket.StringCallback, AsyncHttpClient.WebSocketConnectCallback {
    private static final String CONNECTION_HANDLER = "pt.iscte.ipm.mediacenter.remote.handling.ConnectEventHandler";
    private final RemoteWebSocketService remoteWebSocketService;
    private WebSocket webSocket;
    private ObjectMapper objectMapper = new ObjectMapper();

    public WebSocketHandler(RemoteWebSocketService remoteWebSocketService) {
        this.remoteWebSocketService = remoteWebSocketService;
    }

    @Override
    public void onCompleted(Exception ex, WebSocket webSocket) {
        if (ex != null) {
            ex.printStackTrace();
            return;
        }
        this.webSocket = webSocket;
        webSocket.setStringCallback(this);
        webSocket.send(String.valueOf(new EventOutgoingWrapper(new ConnectEvent("Android1", CONNECTION_HANDLER))));
    }

    @Override
    public void onStringAvailable(String s) {
        Log.d("message received", s);
        try {
            EventIncomingWrapper eventIncomingWrapper = objectMapper.readValue(s, EventIncomingWrapper.class);
            remoteWebSocketService.handle(eventIncomingWrapper.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendEvent(Event event) {
        if (webSocket != null)
            webSocket.send(String.valueOf(new EventOutgoingWrapper(event)));
    }
}
