package com.stfalcon.frescoimageviewersample.features.demo.simple;

import android.os.Bundle;

import com.bumptech.glide.request.RequestOptions;
import com.stfalcon.frescoimageviewer.ImageViewer;
import com.stfalcon.frescoimageviewersample.R;
import com.stfalcon.frescoimageviewersample.features.demo.DemoActivity;
import com.stfalcon.frescoimageviewersample.utils.AppUtils;

public class SimpleUsageActivity extends DemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppUtils.showInfoSnackbar(findViewById(R.id.coordinator),
                R.string.message_open_viewer, true);
    }

    @Override
    protected void showPicker(int startPosition) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.placeholder(R.drawable.play_store_icon);
        requestOptions = requestOptions.skipMemoryCache(true);
        new ImageViewer.Builder<>(this, posters)
                .setRequestOptions(requestOptions)
                .setStartPosition(startPosition)
                .show();
    }
}
