package pt.iscte.ipm.mediacenter.remote.services.websocket;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.squareup.otto.Subscribe;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.RemoteWebsocketBusProvider;

public class RemoteWebSocketService extends Service {
    private final IBinder localBinder = new LocalBinder();
    private WebSocketHandler webSocketHandler = new WebSocketHandler();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service", "start");
        AsyncHttpClient.getDefaultInstance().websocket("ws://192.168.1.15/websocket", null, webSocketHandler);
        RemoteWebsocketBusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RemoteWebsocketBusProvider.getInstance().unregister(this);
    }

    @Subscribe
    public void onEvent(Event event){
        Log.d("qwe0","wqewqewqe");
        sendEvent(new NavigationEvent("ewqw"));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public void sendEvent(Event event){
        webSocketHandler.send(String.valueOf(new EventWrapper(event)));
    }

    public class LocalBinder extends Binder{
        public RemoteWebSocketService getService(){
            return RemoteWebSocketService.this;
        }
    }
}
