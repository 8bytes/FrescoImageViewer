package com.stfalcon.frescoimageviewersample.features.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stfalcon.frescoimageviewersample.R;
import com.stfalcon.frescoimageviewersample.common.data.Demo;

/*
 * Created by troy379 on 06.03.17.
 */
public abstract class DemoActivity extends AppCompatActivity {

    private static final int[] ids = new int[]{
            R.id.firstImage, R.id.secondImage,
            R.id.thirdImage, R.id.fourthImage,
            R.id.fifthImage, R.id.sixthImage,
            R.id.seventhImage, R.id.eighthImage,
            R.id.ninethImage
    };

    protected String[] posters, descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        init();
    }

    protected void showPicker(int startPosition) {

    }

    protected void init() {
        posters = Demo.getPosters();
        descriptions = Demo.getDescriptions();

        for (int i = 0; i < ids.length; i++) {
            ImageView drawee = findViewById(ids[i]);
            initDrawee(drawee, i);
        }
    }

    private void initDrawee(ImageView drawee, final int startPosition) {
        Glide.with(this).load(posters[startPosition]).into(drawee);
        drawee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicker(startPosition);
            }
        });
    }
}
