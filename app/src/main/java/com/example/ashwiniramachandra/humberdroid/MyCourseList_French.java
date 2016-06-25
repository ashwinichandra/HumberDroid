package com.example.ashwiniramachandra.humberdroid;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MyCourseList_French extends Activity {

    private static final String TAG = "Mobile Project";
    private RadioGroup radioGrouplanguages;
    private RadioButton radioButton_english, radioButton_french;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycourselist_fr);
        populateListView();
    }

    private void populateListView() {
        Log.i(TAG,"ListView is populated");
        String[] mycourses_fr = {"programmation Java","Java Avance","Fondation SQL","Systeme Linux","Serveurs"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_fr, mycourses_fr);
        ListView list = (ListView) findViewById(R.id.listViewFrench);
        list.setAdapter(adapter);
        animateListView();
    }

    private void animateListView() {
        Log.d("h", "animate list view");
        ListView lv = (ListView)this.findViewById(R.id.listViewFrench);
        float cx = (float)(lv.getWidth()/2.0);
        float cy = (float)(lv.getHeight()/2.0);
        //lv.startAnimation(new ViewAnimation(cx, cy));
        //lv.startAnimation(new ViewAnimation1(cx, cy));
        lv.startAnimation(new ViewAnimation2());
        // lv.startAnimation(new ViewAnimation3());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}