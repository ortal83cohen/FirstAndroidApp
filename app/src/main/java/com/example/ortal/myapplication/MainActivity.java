package com.example.ortal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends Activity {

    static final String BACKGROUND = "background";

    static int BACKGROUND_VALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] list = {"hi", "hi2", "hi3", "hi4", "hi5"};

        ListView list_view = (ListView) findViewById(R.id.the_list_view);
        ListAdapter listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, list);
        list_view.setAdapter(listAdapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String tvShowPicked = "You selected " +
                        String.valueOf(adapterView.getItemAtPosition(i));

                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();

            }
        });
        if (savedInstanceState != null) {
            ImageView background = (ImageView) findViewById(R.id.imageView2);
            BACKGROUND_VALUE = savedInstanceState.getInt(BACKGROUND);
            Drawable bg = getResources().getDrawable(BACKGROUND_VALUE);

            background.setBackground(bg);
        }

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                RelativeLayout wvContent = (RelativeLayout) findViewById(R.id.ortal);
                try {
                    wvContent.setBackgroundColor(0);
                    ImageView background = (ImageView) findViewById(R.id.imageView2);

                    Drawable bg;
                    if (background.getBackground() == null || BACKGROUND_VALUE != R.drawable.pic2) {
                        BACKGROUND_VALUE = R.drawable.pic2;

                    } else {
                        BACKGROUND_VALUE = R.drawable.ortal;
                    }
                    bg = getResources().getDrawable(BACKGROUND_VALUE);
                    background.setBackground(bg);
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                v.animate().rotationX((float) 1123.1231);

            }

        });


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save the user's current game state
        outState.putInt(BACKGROUND, BACKGROUND_VALUE);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
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

    public void onGetClick(View view) {
        Intent secondScreen = new Intent(this, SecondScreen.class);

        secondScreen.putExtra("test", "test1");
        final int result = 1;
        startActivityForResult(secondScreen, result);
    }
}
