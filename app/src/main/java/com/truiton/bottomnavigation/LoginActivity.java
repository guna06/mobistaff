package com.truiton.bottomnavigation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sloop.fonts.FontsManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Guna on 28-08-2017.
 */

public class LoginActivity extends Activity {
    String LOGIN_STAFF = DataService.STAFF + "staff_login_auth";
    Button btn_submit;
    TextInputLayout text_input_layout1,text_input_layout2,text_input_layout3;
    EditText edt_business_id,edt_user_mail,edt_user_pwd;
    String str_business_id,str_user_mail,str_user_pwd;
    HashMap<String,String> map;
    SharedPreferences s_pref;
    SharedPreferences.Editor edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        FontsManager.initFormAssets(this, "lato.ttf");
        FontsManager.changeFonts(this);

        btn_submit=(Button)findViewById(R.id.btn_submit);
        text_input_layout1=(TextInputLayout) findViewById(R.id.text_input_layout1);
        text_input_layout2=(TextInputLayout) findViewById(R.id.text_input_layout2);
        text_input_layout3=(TextInputLayout) findViewById(R.id.text_input_layout3);
        edt_business_id=(EditText)findViewById(R.id.edt_business_id);
        edt_user_mail=(EditText)findViewById(R.id.edt_user_mail);
        edt_user_pwd=(EditText)findViewById(R.id.edt_user_pwd);

        final Typeface lato = Typeface.createFromAsset(getApplicationContext().getAssets(), "lato.ttf");
        text_input_layout1.setTypeface(lato);
        text_input_layout2.setTypeface(lato);
        text_input_layout3.setTypeface(lato);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_business_id=edt_business_id.getText().toString().trim();
                str_user_mail=edt_user_mail.getText().toString().trim();
                str_user_pwd=edt_user_pwd.getText().toString().trim();

                if(Util.Operations.isOnline(LoginActivity.this)) {
                    if (!edt_business_id.getText().toString().trim().equalsIgnoreCase("")) {
                        text_input_layout1.setError(null);
                        if (!edt_user_mail.getText().toString().trim().equalsIgnoreCase("")) {
                            text_input_layout2.setError(null);

                            if (!edt_user_pwd.getText().toString().trim().equalsIgnoreCase("")) {
                                text_input_layout3.setError(null);


                                new Login_Credential().execute();


                            } else {
                                text_input_layout3.setError("Enter Password");
                                text_input_layout3.requestFocus();
                            }


                        } else {
                            text_input_layout2.setError("Enter Staff Email Id");
                            text_input_layout2.requestFocus();
                        }


                    } else {
                        text_input_layout1.setError("Enter Staff Business Id");
                        text_input_layout1.requestFocus();

                    }
                }else
                {
                    Toast.makeText(getApplicationContext(),"Check Internet COnnection",Toast.LENGTH_LONG).show();
                }

                /*Intent i=new Intent(getApplicationContext(),StaffDashboardActivity.class);
                startActivity(i);
                finish();*/
            }
        });
    }

    private class Login_Credential extends AsyncTask<String,String,String>{

        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String... params) {
            String json = "", jsonStr;
            try {
                Log.e("tag","5");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("business_id", "41");
                jsonObject.accumulate("staff_email", "siva3@sqindia.net");
                jsonObject.accumulate("password", "nmAhYL");
                json = jsonObject.toString();
                return jsonStr = HttpUtils.makeRequest(LOGIN_STAFF, json);
            } catch (Exception e) {
            }
            return null;
        }


        @Override
        protected void onPostExecute(String jsonStr) {
            super.onPostExecute(jsonStr);

            Log.e("tag","01"+jsonStr);


            try {
                JSONObject jo = new JSONObject(jsonStr);
                String status = jo.getString("status");
                Log.e("tag","02"+status);
                String str_api_key= jo.getString("api_key");
                Log.e("tag","03"+str_api_key);



                if (status.equals("true")) {
                    Log.e("tag","1");
                    JSONObject jsonObject = jo.getJSONObject("loginData");
                    map = new HashMap<String, String>();
                    map.put("staff_id", jsonObject.getString("staff_id"));
                    Log.e("tag", "01" + jsonObject.getString("staff_id"));
                    map.put("owner_id", jsonObject.getString("owner_id"));
                    Log.e("tag", "02" + jsonObject.getString("owner_id"));
                    map.put("business_id", jsonObject.getString("business_id"));
                    Log.e("tag","03"+jsonObject.getString("business_id"));
                    map.put("business_location_id", jsonObject.getString("business_location_id"));
                    Log.e("tag", "04" + jsonObject.getString("business_location_id"));
                    map.put("employee_id", jsonObject.getString("employee_id"));
                    Log.e("tag", "05" + jsonObject.getString("employee_id"));
                    map.put("staff_name", jsonObject.getString("staff_name"));
                    Log.e("tag", "06" + jsonObject.getString("staff_name"));
                    map.put("staff_email", jsonObject.getString("staff_email"));
                    Log.e("tag", "07" + jsonObject.getString("staff_email"));


                    map.put("staff_mobile", jsonObject.getString("staff_mobile"));
                    Log.e("tag", "08" + jsonObject.getString("staff_mobile"));
                    map.put("staff_address", jsonObject.getString("staff_address"));
                    Log.e("tag", "09" + jsonObject.getString("staff_address"));
                    map.put("staff_dob", jsonObject.getString("staff_dob"));
                    Log.e("tag","10"+jsonObject.getString("staff_dob"));
                    map.put("staff_blood_group", jsonObject.getString("staff_blood_group"));
                    Log.e("tag", "11" + jsonObject.getString("staff_blood_group"));
                    map.put("staff_profile_logo", jsonObject.getString("staff_profile_logo"));
                    Log.e("tag", "12" + jsonObject.getString("staff_profile_logo"));
                    map.put("staff_role", jsonObject.getString("staff_role"));
                    Log.e("tag", "13" + jsonObject.getString("staff_role"));
                    map.put("staff_joined_date", jsonObject.getString("staff_joined_date"));
                    Log.e("tag", "14" + jsonObject.getString("staff_joined_date"));



                    map.put("business_name", jsonObject.getString("business_name"));
                    Log.e("tag", "15" + jsonObject.getString("business_name"));
                    map.put("business_logo", jsonObject.getString("business_logo"));
                    Log.e("tag", "16" + jsonObject.getString("business_logo"));
                    map.put("exchange_module", jsonObject.getString("exchange_module"));
                    Log.e("tag","17"+jsonObject.getString("exchange_module"));
                    map.put("place_order_module", jsonObject.getString("place_order_module"));
                    Log.e("tag", "18" + jsonObject.getString("place_order_module"));
                    map.put("service_module", jsonObject.getString("service_module"));
                    Log.e("tag", "19" + jsonObject.getString("service_module"));
                    map.put("business_nick_name", jsonObject.getString("business_nick_name"));
                    Log.e("tag", "20" + jsonObject.getString("business_nick_name"));
                    map.put("staff_joined_date", jsonObject.getString("staff_joined_date"));
                    Log.e("tag", "21" + jsonObject.getString("staff_joined_date"));



                    String str_1_id=jsonObject.getString("staff_name");
                    String str_2=jsonObject.getString("staff_email");
                    String str_3=jsonObject.getString("staff_mobile");
                    String str_4=jsonObject.getString("staff_address");
                    String str_owner=jsonObject.getString("owner_id");
                    String str_business=jsonObject.getString("business_id");
                    String str_staff_logo=jsonObject.getString("staff_profile_logo");
                    /*String str_7=jsonObject.getString("auth_level");
                    String str_8=jsonObject.getString("created_at");*/


                    s_pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    edit = s_pref.edit();
                    edit.putString("str1", str_1_id);
                    edit.putString("str2", str_2);
                    edit.putString("str3", str_3);
                    edit.putString("str4", str_4);
                    edit.putString("api_key", str_api_key);
                    edit.putString("owner_id", str_owner);
                    edit.putString("business_id", str_business);
                    edit.putString("staff_img",str_staff_logo);
                    edit.commit();

                    Intent candidate=new Intent(LoginActivity.this,StaffDashboardActivity.class);
                    startActivity(candidate);
                    finish();

                } else {
                    Log.e("tag","1");
                    Toast.makeText(getApplicationContext(), "Check Network Connection", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    }




