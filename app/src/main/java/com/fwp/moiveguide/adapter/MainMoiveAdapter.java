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
 * Created by Administrator on 2017/12/27.
 */
public class MainMoiveAdapter extends RecyclerView.Adapter<MainMoiveAdapter.Holder> {

    private Context context;
    private int[] moives ;
    private String[] moiveNames;
    private int[] colors ={R.color.red,R.color.yello,R.color.purple,R.color.deep_green,R.color.blue,R.color.black,R.color.colorPrimary};

    public MainMoiveAdapter(Context context,String[] moiveNames,int[] moives){
        this.context = context;
        this.moiveNames = moiveNames;
        this.moives = moives;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.item_moive,null));
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.ivBg.setBackgroundResource(moives[position]);
        holder.tvTitle.setText(moiveNames[position]);
        holder.view.setBackgroundResource(colors[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return moives.length;
    }



    public class Holder extends RecyclerView.ViewHolder {
        ImageView ivBg;
        View view;
        TextView tvTitle;

        public Holder(View itemView) {
            super(itemView);
            ivBg = (ImageView) itemView.findViewById(R.id.iv_bg);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            view = itemView.findViewById(R.id.alpha_bg);
        }

    }

    public static interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
