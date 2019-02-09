package com.example.weather_jahirul.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NYSchoolSatScore {
    @SerializedName("currently")
    @Expose
    private Currently currently;

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }
}
