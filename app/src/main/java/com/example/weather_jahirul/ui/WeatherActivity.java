package com.example.weather_jahirul.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.weather_jahirul.R;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new DisplaySummeryFragment(), "DisplaySummeryFragment")
                .addToBackStack(null)
                .commit();
    }
}
