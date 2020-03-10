package com.dev.alpha.leruo;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigation;
    CardView btnHome1,btnHome2,btnHome3,btnHome4,btnHome5,btnHome6;
    ViewFlipper v_flipper;
    ImageView profileView;

    private long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // side Navigation
        navigation = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        v_flipper = (ViewFlipper) findViewById(R.id.slidShow);
        int images[]={R.drawable.cow_model1, R.drawable.cow_model2, R.drawable.cow_model3, R.drawable.cow_model4, R.drawable.cow_model5};

        //iteration loop
        for(int image :images){ slideShow(image);}

        //defining Card view Buttons
        btnHome1 =(CardView) findViewById(R.id.btnHome1);
        btnHome2 =(CardView) findViewById(R.id.btnHome2);
        btnHome3 =(CardView) findViewById(R.id.btnHome3);
        btnHome4 =(CardView) findViewById(R.id.btnHome4);
        btnHome5 =(CardView) findViewById(R.id.btnHome5);
        btnHome6 =(CardView) findViewById(R.id.btnHome6);

        //onclick listener
        btnHome1.setOnClickListener( this);
        btnHome2.setOnClickListener( this);
        btnHome3.setOnClickListener( this);
        btnHome4.setOnClickListener( this);
        btnHome5.setOnClickListener( this);
        btnHome6.setOnClickListener( this);

        initInstances();

    }

    private void initInstances() {

        drawerToggle = new ActionBarDrawerToggle(HomeActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navigation_item_2:
                        startActivity(new Intent(HomeActivity.this,BaitsPageActivity.class));
                        finish();
                        break;

                    case R.id.navigation_item_9:
                        startActivity(new Intent(HomeActivity.this,AboutActivity.class));
                        finish();
                        break;

                    case R.id.navigation_item_10:
                        startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                        finish();
                        break;
                }
                return false;
            }
        });

    }

    public void slideShow(int images){
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
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){return  true;}
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //code here
		 if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
 
        backPressedTime = System.currentTimeMillis();
    }

    //Card view logic
    public void onClick(View view) {
        Intent i;
        switch(view.getId()){
            case R.id.btnHome1:
                i= new Intent(this,OwnershipActivity.class);
                startActivity(i);

                break;
            case R.id.btnHome2:
                i= new Intent(this,IdentityActivity.class);
                startActivity(i);

                break;
            case R.id.btnHome3:
                i= new Intent(this,MovementActivity.class);
                startActivity(i);

                break;
            case R.id.btnHome4:
                i= new Intent(this,RecordsActivity.class);
                startActivity(i);

                break;
            case R.id.btnHome5:
                i= new Intent(this,EartaggingActivity.class);
                startActivity(i);

                break;
            case R.id.btnHome6:
                i= new Intent(this,GeolocationActivity.class);
                startActivity(i);

                break;

            default:break;
        }
    }
}