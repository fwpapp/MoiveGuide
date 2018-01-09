package com.fwp.moiveguide.domain;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.fwp.moiveguide.R;
import com.fwp.moiveguide.adapter.DetailImgsAdapter;
import com.fwp.moiveguide.adapter.DetailStarsImgsAdapter;


/**
 * Created by Administrator on 2017/12/27.
 */
public class DetailsActivity extends Base2Activity {

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView rvImgs,rvStarsImgs;
    private ImageView ivBackdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ivBackdrop = (ImageView) findViewById(R.id.backdrop);
        rvImgs = (RecyclerView) findViewById(R.id.rv_imgs);
        rvStarsImgs = (RecyclerView) findViewById(R.id.rv_stars_imgs);

        // setSupportActionBar(toolbar);

        // collapsingToolbarLayout.setTitle(getIntent().getStringExtra("moiveName"));
        ivBackdrop.setImageResource(getIntent().getIntExtra("moivePic",0));

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvImgs.setLayoutManager(linearLayoutManager);

        rvImgs.setAdapter(new DetailImgsAdapter(this));


        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvStarsImgs.setLayoutManager(linearLayoutManager2);
        rvStarsImgs.setAdapter(new DetailStarsImgsAdapter(this));
    }
}
