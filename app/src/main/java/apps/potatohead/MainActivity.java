package apps.potatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean DEBUG = false;

    public void checkClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        String img_id = checkbox.getText().toString() + "_img";
        if (DEBUG) {
            Log.d("id_checker","The image id = " + img_id);
        }

        int resId = getResources().getIdentifier(img_id, "id", getPackageName());
        ImageView image = findViewById(resId);
        if (checkbox.isChecked()) {
            if (DEBUG){
                Log.d("clicked_checker",checkbox.getText().toString() + " is checked");
            }

            // make image visible
            image.setVisibility(View.VISIBLE);
        }
        else {
            if (DEBUG){
                Log.d("clicked_checker",checkbox.getText().toString() + " is not checked");
            }

            // make image invisible
            image.setVisibility(View.INVISIBLE);
        }
    }
}
