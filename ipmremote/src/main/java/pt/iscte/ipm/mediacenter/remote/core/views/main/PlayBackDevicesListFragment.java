package pt.iscte.ipm.mediacenter.remote.core.views.main;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.squareup.otto.Produce;
import pt.iscte.ipm.mediacenter.events.remote.PlayBackDeviceSelectionEvent;
import pt.iscte.ipm.mediacenter.remote.core.logic.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.BusProvider;

public class PlayBackDevicesListFragment  extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new PlayBackDevicesListAdapter(getActivity()));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        PlayBackDeviceManager.getInstance().setSelected(position);
        BusProvider.getInstance().post(selectPlayBackDevice());
        getFragmentManager().popBackStack();
    }

    @Produce
    public PlayBackDeviceSelectionEvent selectPlayBackDevice(){
        return new PlayBackDeviceSelectionEvent(PlayBackDeviceManager.getInstance().getSelected());
    }
}
