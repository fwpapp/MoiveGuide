package com.fwp.moiveguide;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fwp.moiveguide.adapter.MainMoiveAdapter;
import com.fwp.moiveguide.domain.BaseActivity;
import com.fwp.moiveguide.domain.DetailsActivity;
import com.fwp.moiveguide.domain.MineActivity;

import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class MainActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate, MainMoiveAdapter.OnItemClickListener, View.OnClickListener {

    private BGARefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private LinearLayout llMine;
    private ImageView ivMain;
    private MainMoiveAdapter adapter;
    private String[] moiveNames = {"Star Terk","Super Dog","金刚狼2","分歧者2:绝地反击","蜘蛛侠2","猫妖传","机器之血"};
    private int[] moives = {R.drawable.moive1,R.drawable.moive2,R.drawable.moive3,R.drawable.moive4,R.drawable.moive5,R.drawable.moive6,R.drawable.moive7};
    /*旋转的次数 */
    private int rotateCount = 0;

    // private ObjectAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        refreshLayout = (BGARefreshLayout) findViewById(R.id.rl_refresh);
        ivMain = (ImageView) findViewById(R.id.iv_main);
        llMine = (LinearLayout) findViewById(R.id.ll_mine);

        llMine.setOnClickListener(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new MainMoiveAdapter(this,moiveNames,moives);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        refreshLayout.setDelegate(this);
        final BGAMoocStyleRefreshViewHolder moocStyleRefreshViewHolder = new BGAMoocStyleRefreshViewHolder(this, false);
        moocStyleRefreshViewHolder.setOriginalImage(R.drawable.refresh_logo);
        moocStyleRefreshViewHolder.setUltimateColor(R.color.main_color);
        moocStyleRefreshViewHolder.setRefreshViewBackgroundColorRes(R.color.whie);
        refreshLayout.setRefreshViewHolder(moocStyleRefreshViewHolder);
        refreshLayout.beginRefreshing();

        ivMain.setOnClickListener(this);
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(final BGARefreshLayout refreshLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.endRefreshing();
            }
        },2000);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("moiveName",moiveNames[position]);
        intent.putExtra("moivePic",moives[position]);
        startActivity(intent);
        // overridePendingTransition(R.anim.translate_in,R.anim.translate_out);
    }

    @Override
    public void onClick(final View view) {

        switch (view.getId()){
            case R.id.iv_main:
                ObjectAnimator animator = ObjectAnimator.ofFloat(ivMain,"rotation",72 * rotateCount,72 * rotateCount + 72);
                //ObjectAnimator animator = ObjectAnimator.ofFloat(ivMain,"rotation",0,72);
                animator.setDuration(500);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        refreshLayout.beginRefreshing();
                        view.setClickable(false);
                        if (rotateCount == 4){
                            rotateCount = 0;
                        }else {
                            rotateCount++;
                        }
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        view.setClickable(true);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                animator.start();
                break;
            case R.id.ll_mine:
                startActivity(new Intent(this, MineActivity.class));
                break;
        }
    }

}
