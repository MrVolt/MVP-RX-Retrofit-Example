package com.example.mvp_rx_retrofit_test.model;

import com.example.mvp_rx_retrofit_test.model.entity.EarthquakeData;

import rx.Observable;

/**
 * Created by Volt
 * on 10.11.2016.
 */
public interface IEarthquakeApi {
    Observable<EarthquakeData> getEarthquakes();
}
