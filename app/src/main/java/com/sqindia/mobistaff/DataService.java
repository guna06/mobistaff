package com.sqindia.mobistaff;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Admin on 04-03-2017.
 */

public class DataService {

    public static String STAFF="http://192.168.1.77:8080/MobiAdmin/api/";
    public static String WEB_URL_IMG="http://192.168.1.77:8080/MobiAdmin/assets/img/user_profile/";




    public static boolean isNetworkAvailable(Context c1) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) c1.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

