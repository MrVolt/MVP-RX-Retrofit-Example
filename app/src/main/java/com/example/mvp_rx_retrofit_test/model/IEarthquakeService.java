package com.example.mvp_rx_retrofit_test.model;

import com.example.mvp_rx_retrofit_test.model.entity.EarthquakeData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Volt
 * on 09.11.2016.
 */

public interface IEarthquakeService {
   @GET("query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10")
    Observable<EarthquakeData> getEarthquakeData();
}
