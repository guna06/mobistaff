package com.sqindia.mobistaff;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.gun0912.tedpicker.ImagePickerActivity;
import com.sloop.fonts.FontsManager;

import java.util.ArrayList;
import java.util.Calendar;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by Ramya on 23-03-2017.
 */

public class AddServiceFrag2 extends Fragment {
    static TextInputLayout text_input_layout1, text_input_layout2, text_input_layout3, text_input_layout4,text_input_layout5;
    static EditText edt_esti_cost, edt_accessories, edt_prbm_desc, edt_estimated_dd,edt_remarks;
    static String str_esti_cost, str_accessories, str_prbm_desc, str_estimated_dd,str_remarks;
    static SharedPreferences sharedPrefces2;
    ImageView btn_submit2,img_ticket1,img_ticket2,img_ticket3,img_ticket4;
    private static final int INTENT_REQUEST_GET_IMAGES_DOC1 = 14;
    private static final int INTENT_REQUEST_GET_IMAGES_DOC2 = 15;
    private static final int INTENT_REQUEST_GET_IMAGES_DOC3 = 16;
    private static final int INTENT_REQUEST_GET_IMAGES_DOC4 = 17;

    ArrayList<Uri> image_uris1 = new ArrayList<Uri>();
    ArrayList<Uri> image_uris2 = new ArrayList<Uri>();
    ArrayList<Uri> image_uris3 = new ArrayList<Uri>();
    ArrayList<Uri> image_uris4 = new ArrayList<Uri>();

    String doc1_path,doc2_path,doc3_path,doc4_path;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_service_frag2, container, false);


        FontsManager.initFormAssets(getActivity(), "lato.ttf");
        FontsManager.changeFonts(getActivity());




        final Typeface lato = Typeface.createFromAsset(getActivity().getAssets(), "lato.ttf");



        text_input_layout1 = (TextInputLayout) view.findViewById(R.id.text_input_layout1);
        text_input_layout2 = (TextInputLayout) view.findViewById(R.id.text_input_layout2);
        text_input_layout3 = (TextInputLayout) view.findViewById(R.id.text_input_layout3);
        text_input_layout4 = (TextInputLayout) view.findViewById(R.id.text_input_layout4);
        text_input_layout5 = (TextInputLayout) view.findViewById(R.id.text_input_layout5);


        edt_esti_cost = (EditText) view.findViewById(R.id.edt_esti_cost);
        edt_accessories = (EditText) view.findViewById(R.id.edt_accessories);
        edt_prbm_desc = (EditText) view.findViewById(R.id.edt_prbm_desc);
        edt_estimated_dd = (EditText) view.findViewById(R.id.edt_estimated_dd);
        edt_remarks = (EditText) view.findViewById(R.id.edt_remarks);
        btn_submit2=(ImageView)view.findViewById(R.id.btn_submit2);
        img_ticket1=(ImageView)view.findViewById(R.id.img_ticket1);
        img_ticket2=(ImageView)view.findViewById(R.id.img_ticket2);
        img_ticket3=(ImageView)view.findViewById(R.id.img_ticket3);
        img_ticket4=(ImageView)view.findViewById(R.id.img_ticket4);



        text_input_layout1.setTypeface(lato);
        text_input_layout2.setTypeface(lato);
        text_input_layout3.setTypeface(lato);
        text_input_layout4.setTypeface(lato);
        text_input_layout5.setTypeface(lato);

        edt_esti_cost.setTypeface(lato);
        edt_accessories.setTypeface(lato);
        edt_prbm_desc.setTypeface(lato);
        edt_estimated_dd.setTypeface(lato);
        edt_remarks.setTypeface(lato);


        //*************************** DOCUMENT ONE ONCLICK*********************************************
        img_ticket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean result = Utility.checkPermission(getActivity());
                if (result) {

                    com.gun0912.tedpicker.Config config = new com.gun0912.tedpicker.Config();
                    config.setSelectionMin(1);
                    config.setSelectionLimit(1);
                    ImagePickerActivity.setConfig(config);
                    Intent intent = new Intent(getActivity(), ImagePickerActivity.class);
                    startActivityForResult(intent, INTENT_REQUEST_GET_IMAGES_DOC1);
                }
            }
        });


        //*************************** DOCUMENT TWO ONCLICK*********************************************
        img_ticket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean result = Utility.checkPermission(getActivity());
                if (result) {

                    com.gun0912.tedpicker.Config config = new com.gun0912.tedpicker.Config();
                    config.setSelectionMin(1);
                    config.setSelectionLimit(1);
                    ImagePickerActivity.setConfig(config);
                    Intent intent = new Intent(getActivity(), ImagePickerActivity.class);
                    startActivityForResult(intent, INTENT_REQUEST_GET_IMAGES_DOC2);
                }
            }
        });


        //*************************** DOCUMENT THREE ONCLICK*********************************************
        img_ticket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean result = Utility.checkPermission(getActivity());
                if (result) {

                    com.gun0912.tedpicker.Config config = new com.gun0912.tedpicker.Config();
                    config.setSelectionMin(1);
                    config.setSelectionLimit(1);
                    ImagePickerActivity.setConfig(config);
                    Intent intent = new Intent(getActivity(), ImagePickerActivity.class);
                    startActivityForResult(intent, INTENT_REQUEST_GET_IMAGES_DOC3);
                }
            }
        });


        //*************************** DOCUMENT FOUR ONCLICK*********************************************
        img_ticket4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean result = Utility.checkPermission(getActivity());
                if (result) {

                    com.gun0912.tedpicker.Config config = new com.gun0912.tedpicker.Config();
                    config.setSelectionMin(1);
                    config.setSelectionLimit(1);
                    ImagePickerActivity.setConfig(config);
                    Intent intent = new Intent(getActivity(), ImagePickerActivity.class);
                    startActivityForResult(intent, INTENT_REQUEST_GET_IMAGES_DOC4);
                }
            }
        });



        btn_submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_esti_cost=edt_esti_cost.getText().toString().trim();
                str_accessories=edt_accessories.getText().toString().trim();
                str_prbm_desc=edt_prbm_desc.getText().toString().trim();
                str_estimated_dd=edt_estimated_dd.getText().toString().trim();
                str_remarks=edt_remarks.getText().toString().trim();


                 if (!edt_esti_cost.getText().toString().trim().equalsIgnoreCase("")) {
                    text_input_layout1.setError(null);
                    if (!edt_accessories.getText().toString().trim().equalsIgnoreCase("")) {
                        text_input_layout2.setError(null);
                        if (!edt_prbm_desc.getText().toString().trim().equalsIgnoreCase("")) {
                            text_input_layout3.setError(null);
                            if (!edt_estimated_dd.getText().toString().trim().equalsIgnoreCase("")) {
                                text_input_layout4.setError(null);

                                if (!edt_remarks.getText().toString().trim().equalsIgnoreCase("")) {
                                    text_input_layout5.setError(null);




                                    sharedPrefces2 = PreferenceManager.getDefaultSharedPreferences(getActivity());
                                        SharedPreferences.Editor edit = sharedPrefces2.edit();
                                        edit.putString("e_cost", str_esti_cost);
                                        edit.putString("accessories", str_accessories);
                                        edit.putString("p_desc", str_prbm_desc);
                                        edit.putString("esti_d_date", str_estimated_dd);
                                        edit.putString("remarks",str_remarks);
                                        edit.putString("photo1",doc1_path);
                                        edit.putString("photo2",doc2_path);
                                        edit.putString("photo3",doc3_path);
                                        edit.putString("photo4",doc4_path);
                                        edit.commit();
                                    Log.e("tag","checxk"+str_esti_cost+str_accessories);
                                        AddServiceFragment.pager.setCurrentItem(2);

                        }
                        else
                        {
                            text_input_layout5.setError("Enter Remarks");
                            text_input_layout5.requestFocus();
                        }


                    } else {
                        text_input_layout4.setError("Enter Estimated Delivery Cost");
                        text_input_layout4.requestFocus();
                    }


                } else {
                    text_input_layout3.setError("Enter Problem Description");
                    text_input_layout3.requestFocus();

                }


                   } else {
                        text_input_layout2.setError("Enter Accessories");
                        text_input_layout2.requestFocus();

                    }

                } else {
                    text_input_layout1.setError("Enter Estimated Cost");
                     text_input_layout1.requestFocus();

                }


            }
        });

        return view;
    }




    //*************************************** ALL IMAGES CONDITION**************************************
    @Override
    public void onActivityResult(int requestCode, int resuleCode, Intent intent) {
        super.onActivityResult(requestCode, resuleCode, intent);

         if (requestCode == INTENT_REQUEST_GET_IMAGES_DOC1 && resuleCode == Activity.RESULT_OK) {

            image_uris1 = intent.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);
            Log.e("tag", "333" + image_uris1);

            if (image_uris1 != null) {
                doc1_path = image_uris1.get(0).toString();
                Glide.with(this)
                        .load(doc1_path)
                        .fitCenter()
                        .into(img_ticket1);
                img_ticket1.setBackgroundResource(android.R.drawable.screen_background_light_transparent);
            }
        } else if (requestCode == INTENT_REQUEST_GET_IMAGES_DOC2 && resuleCode == Activity.RESULT_OK) {

            image_uris2 = intent.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);
            Log.e("tag", "333" + image_uris2);

            if (image_uris2 != null) {
                doc2_path = image_uris2.get(0).toString();
                Glide.with(this)
                        .load(doc2_path)
                        .fitCenter()
                        .into(img_ticket2);
                img_ticket2.setBackgroundResource(android.R.drawable.screen_background_light_transparent);
            }
        } else if (requestCode == INTENT_REQUEST_GET_IMAGES_DOC3 && resuleCode == Activity.RESULT_OK) {

            image_uris3 = intent.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);
            Log.e("tag", "333" + image_uris3);

            if (image_uris3 != null) {
                doc3_path = image_uris3.get(0).toString();
                Glide.with(this)
                        .load(doc3_path)
                        .fitCenter()
                        .into(img_ticket3);
                img_ticket3.setBackgroundResource(android.R.drawable.screen_background_light_transparent);
            }
        } else if (requestCode == INTENT_REQUEST_GET_IMAGES_DOC4 && resuleCode == Activity.RESULT_OK) {

            image_uris4 = intent.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);
            Log.e("tag", "333" + image_uris4);

            if (image_uris4 != null) {
                doc4_path = image_uris4.get(0).toString();
                Glide.with(this)
                        .load(doc4_path)
                        .fitCenter()
                        .into(img_ticket4);
                img_ticket4.setBackgroundResource(android.R.drawable.screen_background_light_transparent);
            }
        }

    }






}
