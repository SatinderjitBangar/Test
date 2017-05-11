package com.example.domain.funshine;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;


public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


    }
    public void downloadWeatherData( )
    {

        String type1;
        final JsonObjectRequest jsonRequest=new JsonObjectRequest(Request.Method.GET,"http://api.openweathermap.org/data/2.5/forecast/?lat=9.968782&lon=76.299&APPID=ce763991e00ce03672fb61dfeef347b2", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               Log.v("FUN","RES: "+response.toString());


               /* try {
                    JSONObject team= response.getJSONObject("title");
                    Log.v("FUN","RES: "+response.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("FUN","Err: "+error.getLocalizedMessage());
            }
        });
        Volley.newRequestQueue(this).add(jsonRequest);

    }

}
