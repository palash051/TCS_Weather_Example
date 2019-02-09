package com.example.weather_jahirul.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather_jahirul.R;
import com.example.weather_jahirul.data_access.IWeatherService;
import com.example.weather_jahirul.entities.NYSchoolSatScore;
import com.example.weather_jahirul.services.WeatherService;
import com.example.weather_jahirul.services.WeatherServiceCallBack;

import java.util.ArrayList;
import java.util.List;


public class DisplaySummeryFragment extends Fragment implements WeatherServiceCallBack {

    RecyclerView rvWeatherCityList;
    List<NYSchoolSatScore> nySchoolSatScores;

    public DisplaySummeryFragment() {
        // Required empty public constructor
    }

    public static DisplaySummeryFragment newInstance(String param1, String param2) {
        DisplaySummeryFragment fragment = new DisplaySummeryFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_summery, container, false);
        rvWeatherCityList = view.findViewById(R.id.rvWeatherCityList);
        nySchoolSatScores = new ArrayList<>();
        String locationLA = "37.3855,-122.088";
        String locationNY = "40.7128,-74.0060";

        WeatherService weatherService = new WeatherService();
        weatherService.getSchoolList(this, locationLA);
        weatherService.getSchoolList(this, locationNY);
        return view;
    }

    @Override
    public void executeUpdateList(NYSchoolSatScore nySchoolSatScore) {
        nySchoolSatScores.add(nySchoolSatScore);
    }
}
