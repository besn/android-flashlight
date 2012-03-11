package at.besn.flashlight;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import at.besn.flashlight.R;

public class AboutScreenActivity extends Activity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.about);
  }
}
