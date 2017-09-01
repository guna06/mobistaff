package com.sqindia.mobistaff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sloop.fonts.FontsManager;

import fr.ganfra.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {

    LinearLayout lnr_add_service;
    BottomNavigationView navigation;
    TextView txt_topic1,txt_topic2;
    ImageView img_add;
    private static final String[] SHOP_NAME = {
            "SQIndia Hardware", "Lenovo Showroom - Guduvanchery", "Lenovo Showroom - Chengalpattu", "SQIndia Mobiles - Guduvanchery", "SQIndia Mobiles - Urapakkam"

    };
    MaterialSpinner spin_headoffice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FontsManager.initFormAssets(this, "lato.ttf");
        FontsManager.changeFonts(this);

        lnr_add_service=(LinearLayout)findViewById(R.id.lnr_add_service);
        navigation=(BottomNavigationView) findViewById(R.id.navigation);
        txt_topic1=(TextView) findViewById(R.id.txt_topic1);
        txt_topic2=(TextView) findViewById(R.id.txt_topic2);
        img_add=(ImageView)findViewById(R.id.img_add);
        navigation.setVisibility(View.VISIBLE);

        //########################## ADD NEW SERVICE ##################
        lnr_add_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_add.setVisibility(View.INVISIBLE);
                navigation.setVisibility(View.GONE);
                txt_topic1.setText("Add Entry");
                txt_topic2.setText("Customer Details");
                Fragment fragment = null;
                fragment = new AddServiceFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, fragment);
                transaction.commit();
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_pending:
                                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
                               selectedFragment = ItemOneFragment.newInstance();
                                break;
                            case R.id.navigation_wip:
                                //selectedFragment = ItemTwoFragment.newInstance();
                                break;
                            case R.id.navigation_rwr:
                                //selectedFragment = ItemThreeFragment.newInstance();
                                break;


                        }

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
     /*   FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, Add_Frag_Service_Det.newInstance());
        transaction.commit();*/

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }
}



    /* BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_pending:
                    selectedFragment = Add_Frag_Service_Det.newInstance();
                    break;
                case R.id.navigation_wip:
                   // mTextMessage.setText(R.string.title_dashboard);
                    break;
                case R.id.navigation_rwr:
                   // mTextMessage.setText(R.string.title_notifications);
                    break;

                case R.id.navigation_delivery:
                   // mTextMessage.setText(R.string.title_notifications);
                    break;


            }


            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }

    };





        lnr_add_service=(LinearLayout)findViewById(R.id.lnr_add_service);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




        lnr_add_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"comming soon",Toast.LENGTH_LONG).show();
            }
        });
    }

}
*/



