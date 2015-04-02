package pt.iscte.ipm.mediacenter.remote.services.websocket;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import pt.iscte.ipm.mediacenter.core.events.ConnectEvent;
import pt.iscte.ipm.mediacenter.core.events.ConnectSyncEvent;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.PlayBackDeviceSyncEvent;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;
import pt.iscte.ipm.mediacenter.events.remote.PlayBackDeviceSelectionEvent;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.BusProvider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RemoteWebSocketService extends Service {
    private final IBinder localBinder = new LocalBinder();
    private WebSocketHandler webSocketHandler;
    private Event lastEvent;
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String location = sharedPreferences.getString("server_location", "");
        webSocketHandler = new WebSocketHandler(this, sharedPreferences.getString("device_name", android.os.Build.MODEL));
        AsyncHttpClient.getDefaultInstance().websocket("ws://" + location + "/websocket", null, webSocketHandler);
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public void handle(Event event) {
        try {
            for (Method method : this.getClass().getDeclaredMethods()) {
                if (method.getReturnType() == event.getClass()) {
                    this.lastEvent = event;
                    BusProvider.getInstance().post(method.invoke(this));
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public class LocalBinder extends Binder {
        public RemoteWebSocketService getService() {
            return RemoteWebSocketService.this;
        }
    }

    @Subscribe
    public void onEvent(ConnectEvent event) {
        Log.d("sent", event.toString());
        webSocketHandler.sendEvent(event);
    }

    @Subscribe
    public void onEvent(NavigationEvent event) {
        Log.d("sent", event.toString());
        webSocketHandler.sendEvent(event);
    }

    @Subscribe
    public void onEvent(PlayBackDeviceSelectionEvent event) {
        Log.d("sent", event.toString());
        webSocketHandler.sendEvent(event);
    }

    @Produce
    public PlayBackDeviceSyncEvent playBackDeviceSyncEventReceived() {
        Log.d("received", "playBackDeviceSyncEventReceived");
        return (PlayBackDeviceSyncEvent) lastEvent;
    }

    @Produce
    public ConnectSyncEvent connectSyncEventReceived() {
        Log.d("received", "connectSyncEventReceived");
        return (ConnectSyncEvent) lastEvent;
    }
}
