package com.example.mvp_rx_retrofit_test.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mvp_rx_retrofit_test.R;
import com.example.mvp_rx_retrofit_test.model.entity.Feature;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Volt
 * on 09.10.2016.
 */

public class EarthquakesAdapter extends ArrayAdapter<Feature> {
    private final int placeStep = 2;

    public EarthquakesAdapter(Context context, List<Feature> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Feature earthquake = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);
        }

        TextView magnitudeTextView = (TextView) convertView.findViewById(R.id.magnitude);
        TextView locationKmTextView = (TextView) convertView.findViewById(R.id.location_offset);
        TextView locationPlaceTextView = (TextView) convertView.findViewById(R.id.primary_location);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.date);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);

        String magnitude = earthquake.getProperties().getMag().toString();

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(magnitude);
        magnitudeCircle.setColor(magnitudeColor);

        magnitudeTextView.setText(magnitude);

        String location = earthquake.getProperties().getPlace();
        int splitIndex = location.indexOf("of");

        if (splitIndex != -1 ){
            locationKmTextView.setText(location.substring(0, splitIndex + placeStep).trim());
            locationPlaceTextView.setText(location.substring(splitIndex + placeStep).trim());
        }
        else {
            locationKmTextView.setText(getContext().getText(R.string.nearThe));
            locationPlaceTextView.setText(location);
        }

        Date dateObject = new Date(earthquake.getProperties().getTime());

        dateTextView.setText(formatDate(dateObject));
        timeTextView.setText(formatTime(dateObject));

        return convertView;
    }

    private int getMagnitudeColor(String magnitude) {
        int colorResource = ContextCompat.getColor(getContext(), R.color.magnitude1);
        int magnitudeInt = (int) Math.floor(Double.parseDouble(magnitude));

        switch (magnitudeInt)
        {
            case 0:
            case 1:
                break;
            case 2:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                colorResource = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }

        return colorResource;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}