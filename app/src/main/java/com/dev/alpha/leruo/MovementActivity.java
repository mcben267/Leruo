package com.dev.alpha.leruo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MovementActivity extends AppCompatActivity {

    ViewFlipper v_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement);



        v_flipper = (ViewFlipper) findViewById(R.id.movementFlipper);
        int images[]={R.drawable.cow_model5, R.drawable.cow_model1};
        //iteration loop
        for(int image :images){ slideShow(image);}


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

    @Override
    public void onBackPressed() {
        //code here
        super.onBackPressed();
    }
}
