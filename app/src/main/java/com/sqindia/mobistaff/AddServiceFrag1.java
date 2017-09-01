package com.sqindia.mobistaff;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.TextView;

import com.sloop.fonts.FontsManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by Ramya on 23-03-2017.
 */

public class AddServiceFrag1 extends Fragment {
    static TextInputLayout text_input_layout1, text_input_layout2, text_input_layout3, text_input_layout4;
    static EditText edt_imei, edt_battery, edt_brand, edt_model;
    static String str_imei, str_battery, str_brand, str_model;
    ImageView img_submit;
    static SharedPreferences sharedPrefces;



    MaterialSpinner spin_item_type,spin_item_condition;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_service_frag1, container, false);



        FontsManager.initFormAssets(getActivity(), "lato.ttf");
        FontsManager.changeFonts(getActivity());


        final Typeface lato = Typeface.createFromAsset(getActivity().getAssets(), "lato.ttf");

        text_input_layout1 = (TextInputLayout) view.findViewById(R.id.text_input_layout1);
        text_input_layout2 = (TextInputLayout) view.findViewById(R.id.text_input_layout2);
        text_input_layout3 = (TextInputLayout) view.findViewById(R.id.text_input_layout3);
        text_input_layout4 = (TextInputLayout) view.findViewById(R.id.text_input_layout4);
        spin_item_type = (MaterialSpinner) view.findViewById(R.id.spin_item_type);
        spin_item_condition = (MaterialSpinner) view.findViewById(R.id.spin_item_condition);

        edt_imei = (EditText) view.findViewById(R.id.edt_imei);
        edt_battery = (EditText) view.findViewById(R.id.edt_battery);
        edt_brand = (EditText) view.findViewById(R.id.edt_brand);
        edt_model = (EditText) view.findViewById(R.id.edt_model);

        img_submit = (ImageView) view.findViewById(R.id.img_submit);

        text_input_layout1.setTypeface(lato);
        text_input_layout2.setTypeface(lato);
        text_input_layout3.setTypeface(lato);
        text_input_layout4.setTypeface(lato);

        edt_imei.setTypeface(lato);
        edt_battery.setTypeface(lato);
        edt_brand.setTypeface(lato);
        edt_model.setTypeface(lato);

        List<String> item_type = new ArrayList<String>();
        item_type.add("Mobile");
        item_type.add("Laptops");
        item_type.add("CPU");
        item_type.add("Printer");

        List<String> item_condition = new ArrayList<String>();
        item_condition.add("Damaged");
        item_condition.add("Ok");
        item_condition.add("Broken");


        img_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_imei=edt_imei.getText().toString().trim();
                str_battery=edt_battery.getText().toString().trim();
                str_brand=edt_brand.getText().toString().trim();
                str_model=edt_model.getText().toString().trim();


                /*if (!edt_imei.getText().toString().trim().equalsIgnoreCase("")) {
                    text_input_layout1.setError(null);
                    if (!edt_model.getText().toString().trim().equalsIgnoreCase("")) {
                        til_lname.setError(null);*/
                        if (!edt_imei.getText().toString().trim().equalsIgnoreCase("")) {
                            text_input_layout1.setError(null);
                            if (!edt_battery.getText().toString().trim().equalsIgnoreCase("")) {
                                text_input_layout2.setError(null);

                                if (!edt_brand.getText().toString().trim().equalsIgnoreCase("")) {
                                    text_input_layout3.setError(null);


                                    if (!edt_model.getText().toString().trim().equalsIgnoreCase("")) {
                                        text_input_layout4.setError(null);

                                        sharedPrefces = PreferenceManager.getDefaultSharedPreferences(getActivity());
                                        SharedPreferences.Editor edit = sharedPrefces.edit();
                                        edit.putString("imei", str_imei);
                                        edit.putString("battery_serial", str_battery);
                                        edit.putString("brand", str_brand);
                                        edit.putString("model", str_model);
                                        edit.commit();
                                        AddServiceFragment.pager.setCurrentItem(1);


                                    }
                                    else
                                    {
                                        text_input_layout4.setError("Enter Model");
                                        text_input_layout4.requestFocus();
                                    }

                                }
                                else
                                {
                                    text_input_layout3.setError("Enter Battery Brand");
                                    text_input_layout3.requestFocus();
                                }


                            } else {
                                text_input_layout2.setError("Enter Battery Serial No");
                                text_input_layout2.requestFocus();
                            }


                        } else {
                            text_input_layout1.setError("Enter IMEI or Serial No");
                            text_input_layout1.requestFocus();

                        }


                   /* } else {
                        til_lname.setError("Enter Last Name");
                        til_lname.requestFocus();

                    }

                } else {
                    til_name.setError("Enter Name");
                    til_name.requestFocus();

                }*/





            }
        });

//spinner item type loading
        final CustomAdapter arrayAdapter = new CustomAdapter(getActivity(), android.R.layout.simple_spinner_item, item_type) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                } else {
                    return true;
                }
            }


            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setTypeface(lato);
                tv.setTextSize(14);
                tv.setPadding(10, 15, 10, 15);
                if (position == 0) {
                    tv.setTextColor(Color.BLACK);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setTextSize(14);
                tv.setPadding(5, 0, 0, 0);

                tv.setTypeface(lato);
                if (position == 0) {
                    tv.setTextColor(Color.BLACK);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spin_item_type.setAdapter(arrayAdapter);
        spin_item_type.setPaddingSafe(0, 0, 0, 0);
        //spin_item_type.setOnItemSelectedListener(getActivity());

//spinner item condition loading
        final CustomAdapter arrayAdapter2 = new CustomAdapter(getActivity(), android.R.layout.simple_spinner_item, item_condition) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                } else {
                    return true;
                }
            }


            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setTypeface(lato);
                tv.setTextSize(14);
                tv.setPadding(10, 15, 10, 15);
                if (position == 0) {
                    tv.setTextColor(Color.BLACK);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setTextSize(14);
                tv.setPadding(5, 0, 0, 0);

                tv.setTypeface(lato);
                if (position == 0) {
                    tv.setTextColor(Color.BLACK);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spin_item_condition.setAdapter(arrayAdapter2);
        spin_item_condition.setPaddingSafe(0, 0, 0, 0);

        return view;
    }



}
