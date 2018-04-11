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
        Log.d("create_checker", "check");


        if (not_init) {
            ImageView body = findViewById(R.id.body_img);
            Log.d("not_init checker", "check");
            body.setVisibility(savedInstanceState.getInt("body_img"));
        }
        else {
            Log.d("init_checker", "check");
            not_init = true;
        }
    }

    private boolean DEBUG = false;
    private boolean not_init = false;

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
        Log.d("save_checker", "check");
        outState.putInt("body_img", View.VISIBLE);

//        HashMap<String, Boolean> visibility_map = new HashMap<String, Boolean>();
//        static(
//                visibility_map.put("body_img", false);
//            visibility_map.put("arms_img", false);
//            visibility_map.put("ears_img", false);
//            visibility_map.put("mustache_img", false);
//            visibility_map.put("mouth_img", false);
//            visibility_map.put("eyes_img", false);
//            visibility_map.put("hat_img", false);
//            visibility_map.put("nose_img", false);
//            visibility_map.put("shoes_img", false);
//            visibility_map.put("eyebrows_img", false);
//        )
//
//        for (String img_id : visibility_map.keySet()) {
//            Log.d("name_cheker", img_id);
//            int resId = getResources().getIdentifier(img_id, "id", getPackageName());
//            ImageView image = findViewById(resId);
//            if (image.getVisibility() == View.VISIBLE) {
//                Log.d("visibility_cheker", "is visible");
//                visibility_map.put(img_id, true);
//            } else {
//                Log.d("visibility_cheker", "is not visible");
//                visibility_map.put(img_id, false);
//            }
//        }
    }
}
