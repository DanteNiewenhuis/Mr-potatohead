package apps.potatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // set to true when debugging.
    private boolean DEBUG = false;

    // list to keep track of the images and what is saved.
    private String[] img_list = {"body", "arms", "ears", "eyes", "eyebrows",
                                 "shoes", "nose", "mouth", "hat", "mustache"};
    private boolean[] save_list = {false, false, false, false, false, false,
                                   false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            for (int i = 0; i < img_list.length; i++) {
                // get the identifier of the matching image.
                int resId = getResources().getIdentifier(img_list[i] + "_img", "id", getPackageName());
                ImageView image = findViewById(resId);

                // set the image to visible if it was and set the saved image to true if it was when saved.
                image.setVisibility(savedInstanceState.getInt(img_list[i] + "_img"));
                save_list[i] = savedInstanceState.getBoolean(img_list[i] + "_save");
            }
        }
    }

    public void saveLayout(View v) {
        // loop through the images
        for (int i = 0; i < img_list.length; i++) {
            // get the matching identifier of the image
            int resId = getResources().getIdentifier(img_list[i] + "_img", "id", getPackageName());
            ImageView image = findViewById(resId);

            // set the index to true if the image is visible
            save_list[i] = image.getVisibility() == View.VISIBLE;
        }
    }

    public void loadLayout(View v) {
        // loop through the images
        for (int i = 0; i < img_list.length; i++) {
            // get the matching identifier of the image
            int img_id = getResources().getIdentifier(img_list[i] + "_img", "id", getPackageName());
            ImageView image = findViewById(img_id);

            // get the matching identifier of the checkbox
            int box_id = getResources().getIdentifier(img_list[i] + "_box", "id", getPackageName());
            CheckBox box = findViewById(box_id);

            // set the image to visible and the box checked if the index is true.
            if (save_list[i]) {
                image.setVisibility(View.VISIBLE);
                box.setChecked(true);
            }
            else {
                image.setVisibility(View.INVISIBLE);
                box.setChecked(false);
            }
        }
    }

    public void checkClicked(View v) {
        // Check if the view is a checkbox and get the name of the button
        CheckBox checkbox = (CheckBox) v;
        String check_box_text = checkbox.getText().toString();

        if (DEBUG) {
            Log.d("id_checker","The image id = " + check_box_text);
        }

        // get the image matching the button..
        int resId = getResources().getIdentifier(check_box_text + "_img",
                                                 "id", getPackageName());
        ImageView image = findViewById(resId);

        // make the image visible if the button was checked and otherwise invisible.
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

        // loop through the images
        for (int i = 0; i < img_list.length; i++) {
            // get the indentifier of the matching image.
            int resId = getResources().getIdentifier(img_list[i] + "_img", "id", getPackageName());
            ImageView image = findViewById(resId);

            // save the state of the image and of the save in the bundle.
            outState.putInt(img_list[i] + "_img", image.getVisibility());
            outState.putBoolean(img_list[i] + "_save", save_list[i]);
        }
    }
}
