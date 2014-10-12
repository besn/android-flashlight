package at.besn.flashlight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class FlashLightActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the window title,
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the window to fullscreen...
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // ...and keep the screen from fading to black
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Get the shared preferences
        SharedPreferences sharedPrefs = this.getSharedPreferences("at.besn.flashlight", Context.MODE_PRIVATE);

        // Make the screen full bright for this activity.
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = sharedPrefs.getFloat("at.besn.flashlight.brightness", 1.0f);
        getWindow().setAttributes(lp);

        setContentView(R.layout.activity_flashlight);

        // Set the flashlights color
        RelativeLayout flashLightField = (RelativeLayout) this.findViewById(R.id.flashLightField);
        flashLightField.setBackgroundColor(Color.parseColor(sharedPrefs.getString("at.besn.flashlight.color", "#FFFFFF")));
        flashLightField.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_flash_light, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(FlashLightActivity.this, FlashLightAboutScreenActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRestart() {
        Log.i(getClass().getName(), "onRestart");
        super.onRestart();
    }

    @Override
    public void onStart() {
        Log.i(getClass().getName(), "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(getClass().getName(), "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(getClass().getName(), "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(getClass().getName(), "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(getClass().getName(), "onDestroy");
        super.onDestroy();
    }
}
