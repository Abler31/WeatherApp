package ru.company.retrofitexample.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private String speed;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
