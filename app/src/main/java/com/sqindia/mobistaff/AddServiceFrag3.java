package com.sqindia.mobistaff;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sloop.fonts.FontsManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by Ramya on 23-03-2017.
 */

public class AddServiceFrag3 extends Fragment {
    static TextInputLayout text_input_layout1, text_input_layout2, text_input_layout3, text_input_layout4;
    static EditText edt_name, edt_mobile, edt_email, edt_address;
    static String str_name, str_mobile, str_mail, str_address;
    static SharedPreferences sharedPrefces3;
    Button btn_addservice;
    ArrayList<String> image_path;

    String get_imei,get_battery,get_brand,get_model,get_esti_cost,get_accessories,get_prbm_desc,get_esti_dd,get_remarks,
            get_path1,get_path2,get_path3,get_path4;

    String str_api_key,str_owner_id,str_business_id,str_staff_name,str_staff_mail,str_staff_mobile,str_staff_addr;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_service_frag3, container, false);


        FontsManager.initFormAssets(getActivity(), "lato.ttf");
        FontsManager.changeFonts(getActivity());

        image_path=new ArrayList<>();


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        str_api_key = sharedPreferences.getString("api_key", "");
        str_owner_id= sharedPreferences.getString("owner_id", "");
        str_business_id= sharedPreferences.getString("business_id", "");
        str_staff_name = sharedPreferences.getString("str1", "");
        str_staff_mail = sharedPreferences.getString("str2", "");
        str_staff_mobile = sharedPreferences.getString("str3", "");
        str_staff_addr = sharedPreferences.getString("str4", "");

        get_imei = sharedPreferences.getString("imei", "");
        get_battery = sharedPreferences.getString("battery_serial", "");
        get_brand = sharedPreferences.getString("brand", "");
        get_model = sharedPreferences.getString("model", "");

        get_esti_cost = sharedPreferences.getString("e_cost", "");
        get_accessories = sharedPreferences.getString("accessories", "");
        get_prbm_desc= sharedPreferences.getString("p_desc", "");
        get_esti_dd = sharedPreferences.getString("esti_d_date", "");
        get_remarks = sharedPreferences.getString("remarks", "");

        get_path1 = sharedPreferences.getString("photo1", "");
        get_path2= sharedPreferences.getString("photo2", "");
        get_path3 = sharedPreferences.getString("photo3", "");
        get_path4 = sharedPreferences.getString("photo4", "");

        Log.e("tag","values"+get_imei+get_battery+get_brand+get_model+get_esti_cost+get_accessories+get_prbm_desc+get_esti_dd+get_remarks
        +"  "+get_path1+"  "+get_path2+"  "+get_path3+"   "+get_path4);

        image_path.add(get_path1);
        image_path.add(get_path2);
        image_path.add(get_path3);
        image_path.add(get_path4);
        Log.e("tag","imagepath_print"+image_path);

        final Typeface lato = Typeface.createFromAsset(getActivity().getAssets(), "lato.ttf");

        text_input_layout1 = (TextInputLayout) view.findViewById(R.id.text_input_layout1);
        text_input_layout2 = (TextInputLayout) view.findViewById(R.id.text_input_layout2);
        text_input_layout3 = (TextInputLayout) view.findViewById(R.id.text_input_layout3);
        text_input_layout4 = (TextInputLayout) view.findViewById(R.id.text_input_layout4);
        btn_addservice = (Button) view.findViewById(R.id.btn_addservice);


        edt_name = (EditText) view.findViewById(R.id.edt_name);
        edt_mobile = (EditText) view.findViewById(R.id.edt_mobile);
        edt_email = (EditText) view.findViewById(R.id.edt_email);
        edt_address = (EditText) view.findViewById(R.id.edt_address);

        text_input_layout1.setTypeface(lato);
        text_input_layout2.setTypeface(lato);
        text_input_layout3.setTypeface(lato);
        text_input_layout4.setTypeface(lato);

        edt_name.setTypeface(lato);
        edt_mobile.setTypeface(lato);
        edt_email.setTypeface(lato);
        edt_address.setTypeface(lato);
        btn_addservice.setTypeface(lato);


        btn_addservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_name=edt_name.getText().toString().trim();
                str_mobile=edt_mobile.getText().toString().trim();
                str_mail=edt_email.getText().toString().trim();
                str_address=edt_address.getText().toString().trim();


                if (!edt_name.getText().toString().trim().equalsIgnoreCase("")) {
                    text_input_layout1.setError(null);
                    if (!edt_mobile.getText().toString().trim().equalsIgnoreCase("")) {
                        text_input_layout2.setError(null);
                        if (!edt_email.getText().toString().trim().equalsIgnoreCase("")) {
                            text_input_layout3.setError(null);
                            if (!edt_address.getText().toString().trim().equalsIgnoreCase("")) {
                                text_input_layout4.setError(null);




                                new AddServiceAsync().execute();




/*



*/



                            } else {
                                text_input_layout4.setError("Enter Customer Address");
                                text_input_layout4.requestFocus();
                            }


                        } else {
                            text_input_layout3.setError("Enter Customer Email");
                            text_input_layout3.requestFocus();

                        }


                    } else {
                        text_input_layout2.setError("Enter Customer Mobile No");
                        text_input_layout2.requestFocus();

                    }

                } else {
                    text_input_layout1.setError("Enter Customer Name");
                    text_input_layout1.requestFocus();

                }


            }
        });




        return view;
    }







    //@@@@@@@@@@@@@@@@@@@@@@@@@  Add New SERVICE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private class AddServiceAsync extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... params) {
            String json = "", jsonStr = "";
            try {
                //driver/driverupdate
                String responseString = null;








                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://192.168.1.77:8080/MobiAdmin/api/add_service_entry");
                httppost.setHeader("X-API-KEY", str_api_key);
                httppost.addHeader("business-id", "41");
                httppost.addHeader("business-location-id", "20");
                httppost.addHeader("device-type","Mobile");

                httppost.addHeader("imei-serial", "90190");
                httppost.addHeader("battery-serial", "00099");
                httppost.addHeader("device-condition", "damaged");
                httppost.addHeader("brand", "hj");
                httppost.addHeader("model","mm");


                httppost.addHeader("accessories", "tt");
                httppost.addHeader("problem-desc", "uu");
                httppost.addHeader("estimated-cost", "500");
                httppost.addHeader("estimated-delivery-date", "2007-09-05");
                httppost.addHeader("remarks","hjhjsd");

                httppost.addHeader("customer-name", "sbd");
                httppost.addHeader("customer-contactno", "7676");
                httppost.addHeader("customer-email","guna@sqindia.net");
                httppost.addHeader("customer-address", "chennai");
                httppost.addHeader("added-by","fgfg");
                try {
                    MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                    //entity.addPart("service_device_image", new FileBody(new File(image_path.toString()), "image/jpeg"));
                    //entity.addPart("user_profile", new FileBody(new File(profile_path), "image/jpeg"));
                    //Log.e("tag", "img: if " + profile_path);
                    httppost.setEntity(entity);
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity r_entity = response.getEntity();
                    int statusCode = response.getStatusLine().getStatusCode();
                    Log.e("tag", response.getStatusLine().toString());
                    if (statusCode == 200) {
                        responseString = EntityUtils.toString(r_entity);

                        Log.e("InputStream00", responseString);
                    } else {
                        responseString = "Error occurred! Http Status Code: "
                                + statusCode;
                    }
                } catch (IOException e) {
                    responseString = e.toString();
                    Log.e("InputStream0", responseString);
                }
                return responseString;
            } catch (Exception e) {
                Log.e("InputStream0", e.getLocalizedMessage());
            }
            return null;
        }


        @Override
        protected void onPostExecute(String jsonStr) {
            super.onPostExecute(jsonStr);
            Log.e("tag", "01" + jsonStr);


            try {
                JSONObject jo = new JSONObject(jsonStr);
                String status = jo.getString("status");
                String msg=jo.getString("message");


                if (status.equals("true")) {
                    Log.e("tag", "1");

                    sharedPrefces3 = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    SharedPreferences.Editor edit = sharedPrefces3.edit();
                    edit.clear();
                    edit.commit();
                    Toast.makeText(getActivity(),"ready to work service",Toast.LENGTH_LONG).show();


                    Intent bb=new Intent(getActivity(),AddServiceFragment.class);
                    getActivity().startActivity(bb);


                } else {
                    Log.e("tag", "1");
                    Toast.makeText(getActivity(), "Check Network Connection", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
