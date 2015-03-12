package pt.iscte.ipm.mediacenter.remote;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import pt.iscte.ipm.mediacenter.remote.fragments.MainFragment;
import pt.iscte.ipm.mediacenter.remote.fragments.PrefsFragment;
import pt.iscte.ipm.mediacenter.remote.services.websocket.RemoteWebSocketService;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, RemoteWebSocketService.class);
        startService(intent);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            MainFragment fragment = new MainFragment();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager
                    .beginTransaction();
            PrefsFragment mPrefsFragment = new PrefsFragment();
            mFragmentTransaction.replace(android.R.id.content, mPrefsFragment);
            mFragmentTransaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
