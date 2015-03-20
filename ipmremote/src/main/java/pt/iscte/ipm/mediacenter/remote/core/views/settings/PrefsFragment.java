package pt.iscte.ipm.mediacenter.remote.core.views.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import pt.iscte.ipm.mediacenter.remote.R;

public class PrefsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }


}
