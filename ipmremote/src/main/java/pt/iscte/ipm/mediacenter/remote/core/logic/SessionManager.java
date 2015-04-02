package pt.iscte.ipm.mediacenter.remote.core.logic;

import com.squareup.otto.Subscribe;
import pt.iscte.ipm.mediacenter.core.events.ConnectSyncEvent;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.BusProvider;

import java.util.UUID;

public class SessionManager {
    private static SessionManager ourInstance = new SessionManager();
    private UUID uuid = UUID.randomUUID();

    public  UUID getUuid() {
        return uuid;
    }

    public  void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public static SessionManager getInstance() {
        return ourInstance;
    }

    private SessionManager() {
        BusProvider.getInstance().register(this);
    }

    @Subscribe
    public void onConnectSyncEvent(ConnectSyncEvent evenr){
        this.uuid = UUID.fromString(evenr.getUuid());
    }
}
