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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RelativeLayout wvContent = (RelativeLayout) findViewById(R.id.ortal);
//        ColorDrawable bg1 = (ColorDrawable) getResources().getDrawable(R.drawable.ortal);
//        wvContent.setBackground(bg1);

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                RelativeLayout wvContent = (RelativeLayout) findViewById(R.id.ortal);
                try {
                    wvContent.setBackgroundColor(0);
                    button.setText("Again");
//                    Bitmap bm;
//                    bm = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(filepath),100, 100, true);
//                    ImageView mPicture = new ImageView(context);
//                    mPicture.setImageBitmap(bm);

                    Drawable bg1 = getResources().getDrawable(R.drawable.ortal);
                    Drawable bg =  getResources().getDrawable(R.drawable.pic2);
                    Drawable background = wvContent.getBackground();
                    ImageView background1 = (ImageView) findViewById(R.id.imageView2);


                    if(background1.getBackground()== null || background1.getBackground().getConstantState().equals((bg1.getConstantState()))){
                        background1.setBackground(bg);
                    }else{
                        background1.setBackground(bg1);
                    }

//                bg_color=R.drawable.pix2;
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }


                // Perform action on click
                Random random = new Random();
//                v.animate().cancel();
//                v.animate().start();
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
