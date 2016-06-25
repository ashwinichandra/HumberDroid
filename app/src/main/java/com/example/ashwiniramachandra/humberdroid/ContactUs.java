package com.example.ashwiniramachandra.humberdroid;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class ContactUs extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
