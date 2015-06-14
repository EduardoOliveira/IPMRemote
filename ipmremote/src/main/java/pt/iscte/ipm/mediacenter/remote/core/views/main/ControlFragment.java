package pt.iscte.ipm.mediacenter.remote.core.views.main;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.squareup.otto.Produce;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;
import pt.iscte.ipm.mediacenter.remote.R;
import pt.iscte.ipm.mediacenter.remote.core.logic.SessionManager;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.BusProvider;


public class ControlFragment extends Fragment {


    private View view;
    private String lastKeyEvent="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.new_control_layout, container, false);
        ImageButton leftButton = (ImageButton) view.findViewById(R.id.btn_left);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "left";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton rightButton = (ImageButton) view.findViewById(R.id.btn_right);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "right";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton upButton = (ImageButton) view.findViewById(R.id.btn_up);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "up";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton downButton = (ImageButton) view.findViewById(R.id.btn_down);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "down";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton okButton = (ImageButton) view.findViewById(R.id.btn_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "ok";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton devicesButton = (ImageButton) view.findViewById(R.id.btn_devices);
        devicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "devices";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton backButton = (ImageButton) view.findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "back";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });

        return view;
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
        return new NavigationEvent(SessionManager.getInstance().getUuid().toString(),lastKeyEvent);
    }

}
