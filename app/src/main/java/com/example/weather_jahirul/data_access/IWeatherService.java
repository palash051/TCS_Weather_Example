package com.example.weather_jahirul.data_access;

import com.example.weather_jahirul.entities.NYSchoolSatScore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IWeatherService {

    @GET("forecast/900435862f097f4cc7a2021dd67b8c12/{location}")
    Call<NYSchoolSatScore> getNYSchoolSatScore(@Path("location") String location);

}
