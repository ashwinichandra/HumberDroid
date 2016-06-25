package com.example.ashwiniramachandra.humberdroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private static final String TAG = "Mobile Project";
    private RadioButton radioButton_english, radioButton_french;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Ashwini, n01074309");

        View aboutButton = findViewById(R.id.button_about);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.button_exit);
        exitButton.setOnClickListener(this);
        View contactButton = findViewById(R.id.button_contactme);
        contactButton.setOnClickListener(this);
        View mycourselistButton = findViewById(R.id.button_mycourselist);
        mycourselistButton.setOnClickListener(this);
        View gradesButton = findViewById(R.id.button_grades);
        gradesButton.setOnClickListener(this);
        View mapButton = findViewById(R.id.button_map);
        mapButton.setOnClickListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    public void onClick(View v) {

        radioButton_english = (RadioButton)findViewById(R.id.radio_english);
        radioButton_french = (RadioButton)findViewById(R.id.radio_french);

        if(v.getId() == R.id.button_about ) {
            Log.i(TAG,"About button is clicked");
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }

        else if(v.getId() == R.id.button_map ) {
            Log.i(TAG,"Map button is clicked");
            Intent ma = new Intent(this, MapsActivity.class);
            startActivity(ma);
        }

        else if(v.getId() == R.id.button_contactme){
            Log.i(TAG,"Contact button is clicked");
            Intent cu = new Intent(this, ContactUs.class);
            startActivity(cu);
        }

        else if (v.getId() == R.id.button_grades){
            Log.i(TAG,"Grades button is clicked");
            Intent da = new Intent(this, DatabaseActivity.class);
            startActivity(da);

        }

        else if(radioButton_english.isChecked() && v.getId() == R.id.button_mycourselist) {
            Log.i(TAG,"Radio button english and courselist button is clicked");
            //else if(v.getId() == R.id.button_mycourselist) {
            Intent cl = new Intent(this, MyCourseList.class);
            startActivity(cl);
        }

        else if(radioButton_french.isChecked() && v.getId() == R.id.button_mycourselist) {
            Log.i(TAG,"Radio button french and courselist button is clicked");
            Intent cl = new Intent(this, MyCourseList_French.class);
            startActivity(cl);
        }


        else if(v.getId() == R.id.button_exit){
            Log.i(TAG,"Exit button is clicked");
            finish();
        }



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
