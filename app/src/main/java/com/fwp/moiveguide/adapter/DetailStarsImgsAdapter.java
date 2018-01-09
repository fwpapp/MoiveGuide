package com.fwp.moiveguide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fwp.moiveguide.R;

/**
 * Created by Administrator on 2018/1/3.
 */
public class DetailStarsImgsAdapter extends RecyclerView.Adapter<DetailStarsImgsAdapter.Holder>{

    private Context context;

    public DetailStarsImgsAdapter(Context context){
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.item_stars_img,null));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        if (position == 0){
            holder.tvZhiwei.setText("导演");
        }else {
            holder.tvZhiwei.setText("演员");
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView tvName,tvZhiwei;
        ImageView ivHeader;

        public Holder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvZhiwei = (TextView) itemView.findViewById(R.id.tv_zhiwei);
            ivHeader = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }
}
