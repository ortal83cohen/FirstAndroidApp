package com.example.ortal.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] list = {"hi","hi2","hi3","hi4","hi5"};

        ListView list_view = (ListView)findViewById(R.id.the_list_view);
        ListAdapter list_adapter  = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        list_view.setAdapter(list_adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String tvShowPicked = "You selected " +
                        String.valueOf(adapterView.getItemAtPosition(i));

                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();

            }
        });


        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                RelativeLayout wvContent = (RelativeLayout) findViewById(R.id.ortal);
                try {
                    wvContent.setBackgroundColor(0);

                    Drawable bg1 = getResources().getDrawable(R.drawable.ortal);
                    Drawable bg =  getResources().getDrawable(R.drawable.pic2);
                    Drawable background = wvContent.getBackground();
                    ImageView background1 = (ImageView) findViewById(R.id.imageView2);


                    if(background1.getBackground()== null || background1.getBackground().getConstantState().equals((bg1.getConstantState()))){
                        background1.setBackground(bg);
                    }else{
                        background1.setBackground(bg1);
                    }
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

                v.animate().rotationX((float) 1123.1231);

            }

        });
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
