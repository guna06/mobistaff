/*
 * Copyright (c) 2017. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package com.truiton.bottomnavigation;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sloop.fonts.FontsManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemOneFragment extends Fragment {
    String PENDING_STATUS=DataService.STAFF+"get_pending_service_entries";
    String str_api_key,str_owner_id,str_business_id,str_staff_name,str_staff_mail,str_staff_mobile,str_staff_addr;
    HashMap<String,String> pending_map;
    HashMap<String, HashMap<String, String>> list_childName;
    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_one, container, false);


        FontsManager.initFormAssets(getActivity(), "lato.ttf");
        FontsManager.changeFonts(getActivity());


        final Typeface lato = Typeface.createFromAsset(getActivity().getAssets(), "lato.ttf");
        //listview_pending_data=(ExpandableListView)view.findViewById(R.id.listview_pending_data);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        str_api_key = sharedPreferences.getString("api_key", "");
        str_owner_id= sharedPreferences.getString("owner_id", "");
        str_business_id= sharedPreferences.getString("business_id", "");
        str_staff_name = sharedPreferences.getString("str1", "");
        str_staff_mail = sharedPreferences.getString("str2", "");
        str_staff_mobile = sharedPreferences.getString("str3", "");
        str_staff_addr = sharedPreferences.getString("str4", "");

        list_childName = new HashMap<String, HashMap<String, String>>();
        //new PENDING_ASYNC().execute();



        return view;
    }

/*
    /*//******************************** VIEW PENDING STATUS **************************************
    private class PENDING_ASYNC extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();

        }


        @Override
        protected String doInBackground(String... params) {
            String json = "", jsonStr;
            try {
                Log.e("tag", "5");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("business_id", "41");
                json = jsonObject.toString();
                return jsonStr = HttpUtils.makeRequest2(PENDING_STATUS, json, str_api_key);
            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String jsonStr) {
            Log.e("tag", "whole data" + jsonStr);
            super.onPostExecute(jsonStr);
            //dialog2.dismiss();

            try {
                JSONObject jo = new JSONObject(jsonStr);
                String status = jo.getString("status");
                Log.e("tag", "<-----Status----->" + status);
                if (status.equals("true"))
                {
                    JSONArray data = jo.getJSONArray("pending_entries");

                    Log.e("tag","checking"+data);

                    if (data !=null&& data.length() > 0)
                    {
                        //lnr_empty_dialog.setVisibility(View.GONE);
                        Log.e("tag","1");
                        for (int i1 = 0; i1 < data.length(); i1++) {
                            Log.e("tag", "2");


                            JSONObject jsonObject = data.getJSONObject(i1);
                            pending_map = new HashMap<String, String>();
                            pending_map.put("service_id", jsonObject.getString("service_id"));
                            Log.e("tag", "01" + jsonObject.getString("service_id"));
                            pending_map.put("business_id", jsonObject.getString("business_id"));
                            Log.e("tag", "02" + jsonObject.getString("business_id"));
                            pending_map.put("business_location_id", jsonObject.getString("business_location_id"));
                            Log.e("tag","03"+jsonObject.getString("business_location_id"));
                            pending_map.put("device_type", jsonObject.getString("device_type"));
                            Log.e("tag", "04" + jsonObject.getString("device_type"));
                            pending_map.put("imei_serial", jsonObject.getString("imei_serial"));
                            Log.e("tag", "05" + jsonObject.getString("imei_serial"));
                            pending_map.put("device_condition", jsonObject.getString("device_condition"));
                            Log.e("tag", "06" + jsonObject.getString("device_condition"));
                            pending_map.put("battery_serial", jsonObject.getString("battery_serial"));
                            Log.e("tag", "07" + jsonObject.getString("battery_serial"));
                            pending_map.put("brand", jsonObject.getString("brand"));
                            Log.e("tag", "08" + jsonObject.getString("brand"));
                            pending_map.put("model", jsonObject.getString("model"));
                            Log.e("tag", "09" + jsonObject.getString("model"));
                            pending_map.put("accessories", jsonObject.getString("accessories"));
                            Log.e("tag", "10" + jsonObject.getString("accessories"));
                            pending_map.put("problem_desc", jsonObject.getString("problem_desc"));
                            Log.e("tag", "11" + jsonObject.getString("problem_desc"));
                            pending_map.put("estimated_cost", jsonObject.getString("estimated_cost"));
                            Log.e("tag", "12" + jsonObject.getString("estimated_cost"));
                            pending_map.put("estimated_delivery_date", jsonObject.getString("estimated_delivery_date"));
                            Log.e("tag", "13" + jsonObject.getString("estimated_delivery_date"));
                            pending_map.put("remarks", jsonObject.getString("remarks"));
                            Log.e("tag", "14" + jsonObject.getString("remarks"));
                            pending_map.put("status", jsonObject.getString("status"));
                            Log.e("tag", "15" + jsonObject.getString("status"));
                            pending_map.put("customer_name", jsonObject.getString("customer_name"));
                            Log.e("tag", "16" + jsonObject.getString("customer_name"));
                            pending_map.put("customer_contactno", jsonObject.getString("customer_contactno"));
                            Log.e("tag", "17" + jsonObject.getString("customer_contactno"));
                            pending_map.put("customer_email", jsonObject.getString("customer_email"));
                            Log.e("tag", "18" + jsonObject.getString("customer_email"));
                            pending_map.put("customer_address", jsonObject.getString("customer_address"));
                            Log.e("tag", "19" + jsonObject.getString("customer_address"));


                            Log.e("tag","test"+i1);





                            list_childName.put(String.valueOf(i1) + count+pending_map);
                            ar_count.add(String.valueOf(i1) + count);


                            pendingAdapt.add(pending_map);
                            Log.e("tag", "CONTACT_LIST"+pendingAdapt);
                        }


                        pendingStatusAdapter = new PendingStatusAdapter(getActivity(), list_childName,count);
                        listview_pending_data.setAdapter(pendingStatusAdapter);
                    }

                    else
                    {
                        //lnr_empty_dialog.setVisibility(View.VISIBLE);
                    }
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}*/


}