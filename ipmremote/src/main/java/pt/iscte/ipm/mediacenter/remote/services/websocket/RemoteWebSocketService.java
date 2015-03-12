package pt.iscte.ipm.mediacenter.remote.services.websocket;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.squareup.otto.Subscribe;
import pt.iscte.ipm.mediacenter.remote.services.websocket.events.EventWrapper;
import pt.iscte.ipm.mediacenter.remote.services.websocket.events.RemoteEvent;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.RemoteWebsocketBusProvider;

public class RemoteWebSocketService extends Service {
    private int bla = 0;
    private final IBinder localBinder = new LocalBinder();
    public static final String TAG = "Service";
    private WebSocketHandler webSocketHandler = new WebSocketHandler();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service", "start");
        AsyncHttpClient.getDefaultInstance().websocket("ws://172.17.8.52/remote", null, webSocketHandler);
        RemoteWebsocketBusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RemoteWebsocketBusProvider.getInstance().unregister(this);
    }

    @Subscribe
    public void onEvent(RemoteEvent remoteEvent){
        Log.d("qwe0","wqewqewqe");
        sendEvent(new EventWrapper());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public void sendEvent(EventWrapper eventWrapper){
        webSocketHandler.send("{\n" +
                "\"event_type\":\"pt.iscte.ipm.mediacenter.remote.events.KeyPressRemoteEvent\",\n" +
                "\"remoteEvent\":{\n" +
                "\"keyCode\":\"wqeqe\"\n" +
                "}\n" +
                "}");
    }

    public class LocalBinder extends Binder{
        public RemoteWebSocketService getService(){
            return RemoteWebSocketService.this;
        }
    }
}
