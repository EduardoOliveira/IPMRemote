package pt.iscte.ipm.mediacenter.remote.services.websocket;

import android.util.Log;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;

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
    }

    @Override
    public void onStringAvailable(String s) {
        Log.d("wqeqwe", s);
    }

    public void send(String message) {
        webSocket.send(message);
    }
}
