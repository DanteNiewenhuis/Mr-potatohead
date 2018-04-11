package apps.potatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private boolean DEBUG = false;
    private String[] img_list = {"body_img", "arms_img", "ears_img", "eyes_img", "eyebrows_img",
                                 "shoes_img", "nose_img", "mouth_img", "hat_img", "mustache_img"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            for (String img_id: img_list) {
                int resId = getResources().getIdentifier(img_id, "id", getPackageName());
                ImageView image = findViewById(resId);
                image.setVisibility(savedInstanceState.getInt(img_id));
            }
        }
    }
    public void safeLayout(View v) {

    }



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

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super
        HashMap<String, boolean> last_save = new HashMap<String, boolean>();
        outState.putSerializable("last_save", last_save);
        for (String img_id: img_list) {
            int resId = getResources().getIdentifier(img_id, "id", getPackageName());
            ImageView image = findViewById(resId);
            outState.putInt(img_id, image.getVisibility());
        }
    }
}
