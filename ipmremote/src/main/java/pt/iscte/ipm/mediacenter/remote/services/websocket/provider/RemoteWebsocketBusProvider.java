package pt.iscte.ipm.mediacenter.remote.services.websocket.provider;


import com.squareup.otto.Bus;

public class RemoteWebsocketBusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private RemoteWebsocketBusProvider() {
        // No instances.
    }
}
