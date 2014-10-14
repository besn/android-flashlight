package at.besn.flashlight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import afzkl.development.colorpickerview.dialog.ColorPickerDialog;
import afzkl.development.colorpickerview.view.ColorPickerView;

public class FlashLightActivity extends Activity implements ColorPickerView.OnColorChangedListener {

    SharedPreferences sharedPrefs;

    static final String PREF_COLOR = "at.besn.flashlight.color";
    static final String PREF_BRIGHTNESS = "at.besn.flashlight.brightness";

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
        sharedPrefs = getPreferences(Context.MODE_PRIVATE);

        setContentView(R.layout.activity_flashlight);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Make the screen full bright for this activity.
        setBrightness(sharedPrefs.getFloat(PREF_BRIGHTNESS, 1.0f));
        // Set the flashlights color
        setColor(sharedPrefs.getInt(PREF_COLOR, -1));
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
            case R.id.menu_color:
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this, sharedPrefs.getInt(PREF_COLOR, -1), this);
                colorPickerDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onColorChanged(int newColor) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putInt(PREF_COLOR, newColor);
        edit.commit();
        setColor(newColor);
    }

    private void setBrightness(float brightness) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = brightness;
        getWindow().setAttributes(lp);
    }

    private void setColor(int color) {
        RelativeLayout flashLightField = (RelativeLayout) this.findViewById(R.id.flashLightField);
        flashLightField.setBackgroundColor(color);
        flashLightField.invalidate();
    }
}
