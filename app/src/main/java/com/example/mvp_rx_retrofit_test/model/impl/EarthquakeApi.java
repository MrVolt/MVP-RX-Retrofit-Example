package com.example.mvp_rx_retrofit_test.model.impl;

import com.example.mvp_rx_retrofit_test.model.IEarthquakeApi;
import com.example.mvp_rx_retrofit_test.model.IEarthquakeService;
import com.example.mvp_rx_retrofit_test.model.entity.EarthquakeData;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Volt
 * on 09.11.2016.
 */

public class EarthquakeApi implements IEarthquakeApi {

    //@Override
    public Observable<EarthquakeData> getEarthquakes() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://earthquake.usgs.gov/fdsnws/event/1/")
                .build();

        IEarthquakeService weatherService = retrofit.create(IEarthquakeService.class);

        return weatherService.getEarthquakeData();
    }
}
