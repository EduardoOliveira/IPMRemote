package pt.iscte.ipm.mediacenter.remote.core.views.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import com.squareup.otto.Subscribe;
import pt.iscte.ipm.mediacenter.core.events.DisconnectedFromPlayBackDeviceSyncEvent;
import pt.iscte.ipm.mediacenter.core.events.PlayBackDeviceSyncEvent;
import pt.iscte.ipm.mediacenter.remote.R;
import pt.iscte.ipm.mediacenter.remote.core.logic.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.remote.core.views.settings.SettingsActivity;
import pt.iscte.ipm.mediacenter.remote.services.websocket.RemoteWebSocketService;
import pt.iscte.ipm.mediacenter.remote.services.websocket.provider.BusProvider;


public class MainActivity extends ActionBarActivity {
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private boolean isKeyboardOpen=false;
    private String toastString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Intent intent = new Intent(this, RemoteWebSocketService.class);
        startService(intent);

        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ControlFragment fragment = new ControlFragment();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.search){
            if(isKeyboardOpen){
                closeKeyboard();
            }else{
                ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
            isKeyboardOpen = !isKeyboardOpen;
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        mDrawerLayout.closeDrawers();
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, RemoteWebSocketService.class);
        stopService(intent);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyAction = event.getAction();

        if(keyAction == KeyEvent.ACTION_UP)
        {
            int keyCode = event.getKeyCode();
            if(keyCode == KeyEvent.KEYCODE_ENTER){
                Log.d("qwe", "ENTER");
                closeKeyboard();
            }
            int keyUnicode = event.getUnicodeChar(event.getMetaState() );
            char character = (char) keyUnicode;

            Log.d("qwe","DEBUG MESSAGE KEY=" + character + " KEYCODE=" +  keyCode);
        }

        return super.dispatchKeyEvent(event);
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

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Menu");
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void addDrawerItems() {
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.drawer_items));
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        replaceFragment(new PlayBackDevicesListFragment());
                        break;
                    case 1:
                        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        break;
                }
                mDrawerLayout.closeDrawers();
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void closeKeyboard(){
        EditText myEditText = (EditText) findViewById(R.id.keyBoardHack);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
    }

    @Subscribe
    public void onPlayBackDeviceSync(PlayBackDeviceSyncEvent playBackDeviceSyncEvent){
        Log.d("", "Synced");
        PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
        playBackDeviceManager.setPlayBackDevices(playBackDeviceSyncEvent.getPlayBackDevices());
        if(playBackDeviceManager.getPlayBackDevices().size()>0 && playBackDeviceManager.getSelected()==null){
            if(playBackDeviceManager.getPlayBackDevices().size()==1){//TODO: Refine code
                playBackDeviceManager.setSelected(0);
                BusProvider.getInstance().post(PlayBackDevicesListFragment.selectPlayBackDevice());
            }else{
                replaceFragment(new PlayBackDevicesListFragment());
            }
        }
    }

    @Subscribe
    public void onDisconnectedFromPlayBackDeviceSyncEventReceived(DisconnectedFromPlayBackDeviceSyncEvent event){
        switch (event.getCode()){
            case DisconnectedFromPlayBackDeviceSyncEvent.Code.KICKED:
                toastString=getString(R.string.kicked);
                break;
            case DisconnectedFromPlayBackDeviceSyncEvent.Code.MASTER_DISCONNECTED:
                toastString=getString(R.string.masterDisconnected);
                break;
            case DisconnectedFromPlayBackDeviceSyncEvent.Code.OTHER:
                toastString=getString(R.string.other);
                break;
        }
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(MainActivity.this, toastString, Toast.LENGTH_LONG).show();
            }
        });
    }
}
