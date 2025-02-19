//Anthony Mancia n01643670
package com.example.simpleviews1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    public void btnSaved_clicked (View view) {
        DisplayToast(getString(R.string.Save_btn_Clicked));


    }

    ImageButton imageButton;
    int counter = 1;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        @Override
//        protected void onPause() {
//            super.onPause();
//
//            // Retrieve values from strings.xml
//            String tag = getString(R.string.tag);  // Ensure this exists in strings.xml
//            String message = getString(R.string.Name) + " " + getString(R.string.stdID) ;// Ensure both exist
//
//            // Log the message
//            Log.d(tag, message);
//        }






        imageButton = findViewById(R.id.btnImg1);
        imageButton.setOnClickListener(this::onClick);

        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showSnackbar(buttonView, getString(R.string.SwitchTxt));

                } else {
                    // The toggle is disabled
                }
            }
        });







        //---Button view---
        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        //register the button with an event listener
        btnOpen.setOnClickListener(view -> {
            startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));


        });

//        btnOpen.setOnClickListener(new View.OnClickListener()
//        { //anonymous class
//            //implement your event handler method
//            public void onClick(View v) {
//                DisplayToast(getString(R.string.Open_btn_Clicked));
//            }
//        }


		//---Button view---
		Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.theweathernetwork.com/en")));
        });



//		btnSave.setOnClickListener(new View.OnClickListener()
//		{
//			public void onClick(View v) {
//				DisplayToast("You have clicked the Save button");
//			}
//		});


        //---CheckBox---
        CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);
        checkBox.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                if (((CheckBox)v).isChecked())
                    DisplayToast(getString(R.string.Checkbox_Checked));
                else
                    DisplayToast(getString(R.string.Checkbox_Unchecked));
            }
        });

        //---RadioButton---
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdbGp1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) findViewById(R.id.rdb1);
                if (rb1.isChecked()) {
                    DisplayToast(getString(R.string.Option1Checked));
                } else {
                    DisplayToast(getString(R.string.Option2Checked));
                }
            }
        });

        //---ToggleButton---
        ToggleButton toggleButton =
                (ToggleButton) findViewById(R.id.toggle1);
        toggleButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                if (((ToggleButton)v).isChecked())
                    DisplayToast(getString(R.string.Toggle_On));
                else
                    DisplayToast(getString(R.string.Toggle_Off));
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.dialog_title));
        builder.setMessage(getString(R.string.dialog_message));
        builder.setIcon(R.drawable.exitsign);


        builder.setPositiveButton(getString(R.string.yes_button), (dialog, which) -> finish());


        builder.setNegativeButton(getString(R.string.no_button), (dialog, which) -> dialog.dismiss());


        builder.setCancelable(false);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClick(View view) {
        if (counter == 1) {
            imageButton.setImageResource(R.drawable.helicopter);
            DisplayToast(getString(R.string.Name) + "+ " + getString(R.string.image1Toast));
        } else if (counter == 2) {
            imageButton.setImageResource(R.drawable.plane);
            DisplayToast(getString(R.string.Name) + "+ " + getString(R.string.image2Toast));
        } else if (counter == 3) {
            imageButton.setImageResource(R.drawable.car);
            DisplayToast(getString(R.string.Name) + "+ " + getString(R.string.image3Toast));
        } else if (counter == 4) {
            imageButton.setImageResource(R.drawable.boat);
            DisplayToast(getString(R.string.Name) + "+ " + getString(R.string.image4Toast));
            counter = 0; // Reset after 4 clicks
        }

        counter++;
    }


    private void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).show();
    }

    public void onPause() {
        super.onPause();

        String tag = getString(R.string.tag);
        String message = getString(R.string.Name) + " " + getString(R.string.stdID);

        Log.d(tag, message); // Corrected Log.d() syntax
    }


    private void DisplayToast(String msg)
    {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }
}