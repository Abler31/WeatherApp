package ru.company.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.cert.LDAPCertStoreParameters;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.company.retrofitexample.Retrofit.ApiClient;
import ru.company.retrofitexample.Retrofit.Example;
import ru.company.retrofitexample.Retrofit.JsonPlaceHolderApi;

public class MainActivity extends AppCompatActivity {
    TextView city, temp, description, humidity, wind;
    ImageView icon, search;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.tv_city);
        temp = findViewById(R.id.tv_temp);
        description = findViewById(R.id.tv_desc);
        humidity = findViewById(R.id.tv_humidity);
        wind = findViewById(R.id.tv_wind);
        icon = findViewById(R.id.iv_icon);
        search = findViewById(R.id.iv_search);
        textField = findViewById(R.id.et_search);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWeatherData(textField.getText().toString().trim());
                Log.d("DATA", "кнопка нажата");
            }
        });



    }

    private void getWeatherData(String name){
        JsonPlaceHolderApi apiInterface = ApiClient.getRetrofitInstance().create(JsonPlaceHolderApi.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                city.setText(response.body().getCity());
                temp.setText(getString(R.string.temp, response.body().getMain().getTemp()));
                description.setText(response.body().getWeather().get(0).getDescription());
                humidity.setText(String.format(getString(R.string.humidity, response.body().getMain().getHumidity())));
                wind.setText(getString(R.string.wind, response.body().getWind().getSpeed()));
                String pic = response.body().getWeather().get(0).getIcon();
                switch (pic){
                    case  ("01d"):
                        icon.setImageResource(R.drawable.d01);
                        break;
                    case  ("01n"):
                        icon.setImageResource(R.drawable.n01);
                        break;
                    case  ("02d"):
                        icon.setImageResource(R.drawable.d02);
                        break;
                    case  ("02n"):
                        icon.setImageResource(R.drawable.n02);
                        break;
                    case  ("03d"):
                        icon.setImageResource(R.drawable.d03);
                        break;
                    case  ("03n"):
                        icon.setImageResource(R.drawable.n03);
                        break;
                    case  ("04d"):
                        icon.setImageResource(R.drawable.d04);
                        break;
                    case  ("04n"):
                        icon.setImageResource(R.drawable.n04);
                        break;
                    case  ("09d"):
                        icon.setImageResource(R.drawable.d09);
                        break;
                    case  ("09n"):
                        icon.setImageResource(R.drawable.n09);
                        break;
                    case  ("10d"):
                        icon.setImageResource(R.drawable.d10);
                        break;
                    case  ("10n"):
                        icon.setImageResource(R.drawable.n10);
                        break;
                    case  ("11d"):
                        icon.setImageResource(R.drawable.d11);
                        break;
                    case  ("11n"):
                        icon.setImageResource(R.drawable.n11);
                        break;
                    case  ("13d"):
                        icon.setImageResource(R.drawable.d13);
                        break;
                    case  ("13n"):
                        icon.setImageResource(R.drawable.n13);
                        break;
                    case  ("50d"):
                        icon.setImageResource(R.drawable.d50);
                        break;
                    case  ("50n"):
                        icon.setImageResource(R.drawable.n50);
                        break;

                }
                Log.d("DATA", "onResponse");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("DATA", "onFailure");
                t.printStackTrace();
            }
        });
    }

}
