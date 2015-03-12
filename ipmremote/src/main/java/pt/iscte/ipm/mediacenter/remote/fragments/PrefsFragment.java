package pt.iscte.ipm.mediacenter.remote.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import pt.iscte.ipm.mediacenter.remote.R;

/**
 * Created by KnoKer on 09/03/2015.
 */
public class PrefsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.prefs);
    }
}
