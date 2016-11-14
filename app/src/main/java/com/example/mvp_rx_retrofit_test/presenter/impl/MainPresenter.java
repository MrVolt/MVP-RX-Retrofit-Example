package com.example.mvp_rx_retrofit_test.presenter.impl;

import com.example.mvp_rx_retrofit_test.model.entity.EarthquakeData;
import com.example.mvp_rx_retrofit_test.model.entity.Feature;
import com.example.mvp_rx_retrofit_test.model.impl.EarthquakeApi;
import com.example.mvp_rx_retrofit_test.presenter.IMainPresenter;
import com.example.mvp_rx_retrofit_test.view.IMainView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Volt
 * on 09.11.2016.
 */

public class MainPresenter implements IMainPresenter {
    private final EarthquakeApi _earthquakeApi;
    private final IMainView _view;

    public MainPresenter(IMainView view) {
        _earthquakeApi = new EarthquakeApi();
        _view = view;
    }

    @Override
    public void getEarthquakesData(boolean isUpdate) {
        Observable<EarthquakeData> dataObservable = _earthquakeApi.getEarthquakes();

        dataObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(earthquakeData ->
                {
                    List<Feature> earthquakes = new ArrayList<>();
                    earthquakes.addAll(earthquakeData.getFeatures());

                    _view.hideLoadingIndicator();

                    if (earthquakes.isEmpty()) _view.setEmptyResponseText("There is no earthquakes");
                    else if (isUpdate) _view.updateEarthquakesListView(earthquakes);
                    else _view.setEarthquakesListViewData(earthquakes);
                });
    }
}
