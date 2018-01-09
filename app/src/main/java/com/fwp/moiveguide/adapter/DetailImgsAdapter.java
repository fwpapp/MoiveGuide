package com.fwp.moiveguide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fwp.moiveguide.R;

/**
 * Created by Administrator on 2018/1/3.
 */
public class DetailImgsAdapter extends RecyclerView.Adapter<DetailImgsAdapter.Holder> {

    private Context context;

    public DetailImgsAdapter(Context context){
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.item_detail_img,null));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }
}
