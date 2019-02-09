package com.example.weather_jahirul.services;

import android.support.v4.app.Fragment;

import com.example.weather_jahirul.data_access.IWeatherService;
import com.example.weather_jahirul.entities.NYSchoolSatScore;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherService {

    IWeatherService iWeatherService;
    WeatherServiceCallBack weatherServiceCallBack;

    public void getSchoolList(Fragment context, String location) {
        iWeatherService = APIClient.getClient().create(IWeatherService.class);
        weatherServiceCallBack = (WeatherServiceCallBack) context;
        getWeatherData(location);

    }

    private void getWeatherData(String locationLA) {

        Call<NYSchoolSatScore> call = iWeatherService.getNYSchoolSatScore(locationLA);
        call.enqueue(new Callback<NYSchoolSatScore>() {
            @Override
            public void onResponse(Call<NYSchoolSatScore> call, Response<NYSchoolSatScore> response) {

                weatherServiceCallBack.executeUpdateList(response.body());
            }

            @Override
            public void onFailure(Call<NYSchoolSatScore> call, Throwable t) {
                call.cancel();
            }
        });
    }

}
