package com.sqindia.mobistaff;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sloop.fonts.FontsManager;

/**
 * Created by Guna on 28-08-2017.
 */

public class StaffDashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout lnr_service,lnr_placeorder,exchange;
    String str_api_key,str_staff_name,str_staff_mail,str_staff_mobile,str_staff_addr,str_owner_id,str_business_id,staff_image;
    ImageView img_nav,imageview_profile;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    TextView textview_staffname,textview_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboarad);

        lnr_service=(LinearLayout)findViewById(R.id.lnr_service);
        lnr_placeorder=(LinearLayout)findViewById(R.id.lnr_placeorder);
        exchange=(LinearLayout)findViewById(R.id.exchange);
        img_nav=(ImageView)findViewById(R.id.img_nav);
        imageview_profile=(ImageView)findViewById(R.id.imageview_profile) ;
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textview_staffname=(TextView) findViewById(R.id.textview_staffname);
        textview_email=(TextView) findViewById(R.id.textview_email);

        FontsManager.initFormAssets(this, "lato.ttf");
        FontsManager.changeFonts(this);

        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.app_name, R.string.app_name);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ GET VALUE FROM ADMIN LOGIN(USING SHARED) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        str_api_key = sharedPreferences.getString("api_key", "");
        str_staff_name = sharedPreferences.getString("str1", "");
        str_staff_mail = sharedPreferences.getString("str2", "");
        str_staff_mobile = sharedPreferences.getString("str3", "");
        str_staff_addr = sharedPreferences.getString("str4", "");
        str_owner_id= sharedPreferences.getString("owner_id", "");
        str_business_id= sharedPreferences.getString("business_id", "");
        staff_image=sharedPreferences.getString("staff_img","");
        Log.e("tag","staff_profile"+staff_image);

        String kk="http://192.168.1.77:8080/MobiAdmin/assets/img/user_profile/"+staff_image;
        Log.e("tag","staff_profile2"+kk);

        Glide.with(StaffDashboardActivity.this)
                .load(kk)
                .into(imageview_profile);


        if(!(sharedPreferences.getString("staff_image","").equals(""))){

            String img = sharedPreferences.getString("staff_img","");
            Log.e("tag_dr","dr: "+img);

        }

        textview_staffname.setText(str_staff_name);
        textview_email.setText(str_staff_mail);


        Log.e("tag","values"+str_api_key+str_staff_name+str_staff_mail+str_staff_mobile+str_staff_addr);



        lnr_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service_module=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(service_module);
                finish();
            }
        });


        lnr_placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Comming Soon",Toast.LENGTH_LONG).show();
            }
        });


        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Comming Soon",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
