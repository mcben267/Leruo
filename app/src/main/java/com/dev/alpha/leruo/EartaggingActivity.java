package com.dev.alpha.leruo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class EartaggingActivity extends AppCompatActivity {

    ViewFlipper v_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eartagging);

        v_flipper = (ViewFlipper) findViewById(R.id.earTaggingFlipper);
        int images[]={R.drawable.eartag1, R.drawable.eartag0, R.drawable.eartag2, R.drawable.eartag3};
        //iteration loop
        for(int image :images){ slideShow(image);}


    }


    @Override
    public void onBackPressed() {
        //code here
        super.onBackPressed();
    }

    private void slideShow(int images){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(5000);    //5 sec
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
