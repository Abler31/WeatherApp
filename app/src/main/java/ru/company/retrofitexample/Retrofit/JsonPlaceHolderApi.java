package ru.company.retrofitexample.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("weather?lang=ru&appid=878ca7a39a58c96a691d32c4dbff1675&units=metric")
    Call<Example> getWeatherData(@Query("q") String city);
}
