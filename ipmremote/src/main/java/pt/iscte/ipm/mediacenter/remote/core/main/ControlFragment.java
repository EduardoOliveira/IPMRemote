package pt.iscte.ipm.mediacenter.remote.core.main;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import pt.iscte.ipm.mediacenter.core.events.PlayBackDeviceSyncEvent;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;
import pt.iscte.ipm.mediacenter.remote.R;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.BusProvider;


public class ControlFragment extends Fragment {


    private View view;
    private String lastKeyEvent="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.control_layout, container, false);
        Button leftButton = (Button) view.findViewById(R.id.left_button);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "left";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        Button rightButton = (Button) view.findViewById(R.id.right_button);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "right";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        Button upButton = (Button) view.findViewById(R.id.up_button);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "up";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        Button downButton = (Button) view.findViewById(R.id.down_button);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "down";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        Button okButton = (Button) view.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "ok";
                BusProvider.getInstance().post(fireKeyPress());
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
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Produce
    public NavigationEvent fireKeyPress() {
        return new NavigationEvent(lastKeyEvent);
    }

    @Subscribe
    public void onPlayBackDeviceSync(PlayBackDeviceSyncEvent playBackDeviceSyncEvent){
        Log.d("qwe",playBackDeviceSyncEvent.toString());
        //BusProvider.getInstance().post();
    }
}
