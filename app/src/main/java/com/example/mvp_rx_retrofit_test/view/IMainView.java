package com.example.mvp_rx_retrofit_test.view;

import com.example.mvp_rx_retrofit_test.model.entity.Feature;

import java.util.List;

/**
 * Created by Volt
 * on 09.11.2016.
 */

public interface IMainView {
    void setEarthquakesListViewData(List<Feature> earthquakes);
    void updateEarthquakesListView(List<Feature> earthquakes);
    void setEmptyResponseText(String text);
    void hideLoadingIndicator();
    void showNoConnectionMessage();
}
