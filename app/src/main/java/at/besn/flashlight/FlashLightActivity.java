package at.besn.flashlight;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class FlashLightActivity extends Activity {

  public SharedPreferences sharedPrefs;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Hide the window title,
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    // set the window to fullscreen...
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    // ...and keep the screen from fading to black
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    // Make the screen full bright for this activity.
    WindowManager.LayoutParams lp = getWindow().getAttributes();
    lp.screenBrightness = 1.0f;
    getWindow().setAttributes(lp);

    setContentView(R.layout.activity_flashlight);
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
