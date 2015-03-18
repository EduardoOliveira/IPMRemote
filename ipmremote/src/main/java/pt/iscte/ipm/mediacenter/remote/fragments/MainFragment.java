package pt.iscte.ipm.mediacenter.remote.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.squareup.otto.Produce;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;
import pt.iscte.ipm.mediacenter.remote.R;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.RemoteWebsocketBusProvider;


public class MainFragment extends Fragment {


    private View view;
    private String lastKeyEvent="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_layout, container, false);
        Button leftButton = (Button) view.findViewById(R.id.left_button);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "left";
                RemoteWebsocketBusProvider.getInstance().post(keyPressed());
            }
        });
        Button rightButton = (Button) view.findViewById(R.id.right_button);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "right";
                RemoteWebsocketBusProvider.getInstance().post(keyPressed());
            }
        });
        Button upButton = (Button) view.findViewById(R.id.up_button);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "up";
                RemoteWebsocketBusProvider.getInstance().post(keyPressed());
            }
        });
        Button downButton = (Button) view.findViewById(R.id.down_button);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "down";
                RemoteWebsocketBusProvider.getInstance().post(keyPressed());
            }
        });
        Button okButton = (Button) view.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "ok";
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
        Log.d("wqe", "qwe");
        RemoteWebsocketBusProvider.getInstance().register(this);
    }

    @Produce
    public NavigationEvent keyPressed() {
        return new NavigationEvent(lastKeyEvent);
    }
}
