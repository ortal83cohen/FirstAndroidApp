package com.example.ortal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ortal on 09-Feb-15.
 */
public class SecondScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        Intent previousActivity = getIntent();

        String test = previousActivity.getStringExtra("test");
        Toast.makeText(SecondScreen.this, test, Toast.LENGTH_SHORT).show();
    }

    public void onGetClick(View view) {
        Intent mainActivity = new Intent(this,MainActivity.class);

        mainActivity.putExtra("test","test1");
        final int result = 1;
        startActivityForResult(mainActivity,result);
        finish();
    }
}
