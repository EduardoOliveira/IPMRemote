package pt.iscte.ipm.mediacenter.remote.core.views.main;

import android.app.Fragment;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;
import com.squareup.otto.Produce;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;
import pt.iscte.ipm.mediacenter.events.remote.VolumeChangeEvent;
import pt.iscte.ipm.mediacenter.remote.R;
import pt.iscte.ipm.mediacenter.remote.core.logic.SessionManager;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.BusProvider;


public class ControlFragment extends Fragment {

    public int volume;
    private String lastKeyEvent="";
    public String TAG = this.getClass().toString();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.control_layout, container, false);
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
        Button okButton = (Button) view.findViewById(R.id.btn_ok);
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

        ImageButton rewindButton = (ImageButton) view.findViewById(R.id.btn_rewind);
        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "rewind";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton playButton = (ImageButton) view.findViewById(R.id.btn_play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "play";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton forwardButton = (ImageButton) view.findViewById(R.id.btn_forward);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "forward";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton homeButton = (ImageButton) view.findViewById(R.id.btn_home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "forward";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });
        ImageButton infoButton = (ImageButton) view.findViewById(R.id.btn_info);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastKeyEvent = "forward";
                BusProvider.getInstance().post(fireKeyPress());
            }
        });

        SeekBar volumeControl = (SeekBar) view.findViewById(R.id.volume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                volume = progress;
                Log.d(TAG,progress + "");
                BusProvider.getInstance().post(fireVolumeChange());
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

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

    @Produce
    public VolumeChangeEvent fireVolumeChange(){
        return new VolumeChangeEvent(SessionManager.getInstance().getUuid().toString(),volume);
    }

}
