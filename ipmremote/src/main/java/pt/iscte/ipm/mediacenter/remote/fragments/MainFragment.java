package pt.iscte.ipm.mediacenter.remote.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.squareup.otto.Produce;
import pt.iscte.ipm.mediacenter.remote.R;
import pt.iscte.ipm.mediacenter.remote.events.NavigationEvent;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.RemoteWebsocketBusProvider;

public class MainFragment extends Fragment {


    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_layout, container, false);
        Button btn = (Button) view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("wqe", "wqeqwe");
                RemoteWebsocketBusProvider.getInstance().post(keyPressed());
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        RemoteWebsocketBusProvider.getInstance().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("wqe","qwe");
        RemoteWebsocketBusProvider.getInstance().register(this);
    }

    @Produce
    public NavigationEvent keyPressed(){
        return new NavigationEvent("bla");
    }
}
