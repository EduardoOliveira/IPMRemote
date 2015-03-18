package pt.iscte.ipm.mediacenter.remote.services.websocket;

import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import pt.iscte.ipm.mediacenter.core.events.*;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.RemoteWebsocketBusProvider;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class WebSocketHandler implements WebSocket.StringCallback, AsyncHttpClient.WebSocketConnectCallback {
    private WebSocket webSocket;
    private static final String CONNECTION_HANDLER = "pt.iscte.ipm.mediacenter.remote.handling.ConnectEventHandler";
    private Event lastEvent;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onCompleted(Exception ex, WebSocket webSocket) {
        if (ex != null) {
            ex.printStackTrace();
            return;
        }
        this.webSocket = webSocket;
        webSocket.setStringCallback(this);
        webSocket.send(String.valueOf(new EventOutgoingWrapper(new ConnectEvent("Android1",CONNECTION_HANDLER))));
    }

    @Override
    public void onStringAvailable(String s) {
        Log.d("message received", s);
        try {
            EventIncomingWrapper eventIncomingWrapper = objectMapper.readValue(s, EventIncomingWrapper.class);

            for(Method method : this.getClass().getDeclaredMethods()){
                if(method.getReturnType()==eventIncomingWrapper.getEvent().getClass()){
                    RemoteWebsocketBusProvider.getInstance().post(method.invoke(this));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void handleEvent(PlayBackDeviceSyncEvent data) {
        this.lastEvent = data;
        RemoteWebsocketBusProvider.getInstance().post(playBackDeviceSyncEventReceived());
    }

    public void send(String message) {
        webSocket.send(message);
    }

    @Produce
    public PlayBackDeviceSyncEvent playBackDeviceSyncEventReceived(){
        return (PlayBackDeviceSyncEvent)lastEvent;
    }
}
