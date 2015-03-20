package pt.iscte.ipm.mediacenter.remote.core.views.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import pt.iscte.ipm.mediacenter.pojos.PlayBackDevice;
import pt.iscte.ipm.mediacenter.remote.R;
import pt.iscte.ipm.mediacenter.remote.core.logic.PlayBackDeviceManager;

public class PlayBackDevicesListAdapter extends ArrayAdapter<PlayBackDevice>{
    public PlayBackDevicesListAdapter(Context context) {
        super(context, R.layout.playback_devices_layout,
                PlayBackDeviceManager.getInstance().getPlayBackDevices());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView  = layoutInflater.inflate(R.layout.playback_devices_layout,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.device_name = (TextView) convertView.findViewById(R.id.device_name);
            viewHolder.now_playing = (TextView) convertView.findViewById(R.id.now_playing);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PlayBackDevice item = getItem(position);
        viewHolder.device_name.setText(item.getName());
        viewHolder.now_playing.setText("Playing: "+item.getCurrentlyPlaying());

        return convertView;
    }

    private static class ViewHolder {
        TextView device_name;
        TextView now_playing;
    }
}
