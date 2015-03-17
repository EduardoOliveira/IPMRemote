package pt.iscte.ipm.mediacenter.remote.services.websocket;

import android.util.Log;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import pt.iscte.ipm.mediacenter.core.events.ConnectEvent;
import pt.iscte.ipm.mediacenter.core.events.EventIncomingWrapper;
import pt.iscte.ipm.mediacenter.core.events.EventOutgoingWrapper;

public class WebSocketHandler implements WebSocket.StringCallback, AsyncHttpClient.WebSocketConnectCallback {
    private WebSocket webSocket;

    @Override
    public void onCompleted(Exception ex, WebSocket webSocket) {
        if (ex != null) {
            ex.printStackTrace();
            return;
        }
        this.webSocket = webSocket;
        webSocket.setStringCallback(this);
        webSocket.send(String.valueOf(new EventOutgoingWrapper(new ConnectEvent("pt.iscte.ipm.mediacenter.remote.devices.RemoteControl","Android1"))));
    }

    @Override
    public void onStringAvailable(String s) {
        Log.d("wqeqwe", s);
    }

    public void send(String message) {
        webSocket.send(message);
    }
}
