package com.example.xiangmu.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.R;
import com.example.xiangmu.json.PzshBean;
import com.example.xiangmu.view.activity.XiangQAdapter;

import org.greenrobot.eventbus.EventBus;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/16 21:32:28
 * @Description:
 */
public class HomePzshAdapter extends RecyclerView.Adapter<HomePzshAdapter.ViewHolder> {
    Context context; PzshBean pzshBean;
    public HomePzshAdapter(Context context, PzshBean pzshBean) {
        this.context=context;
        this.pzshBean=pzshBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_rxxp, null);
        HomePzshAdapter.ViewHolder viewHolder = new HomePzshAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.rxxp_name.setText(pzshBean.getResult().get(position).getCommodityName());
        holder.rxxp_price.setText("价格："+pzshBean.getResult().get(position).getPrice()+"");
        holder.prirxxp_xiaoliangce.setText("已售"+pzshBean.getResult().get(position).getSaleNum()+"");
        Glide.with(context)
                .load(pzshBean.getResult().get(position).getMasterPic())
                .into(holder.rxxp_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(pzshBean.getResult().get(position).getCommodityId());
                context.startActivity(new Intent(context,XiangQAdapter.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return pzshBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rxxp_img;
        TextView rxxp_name;
        TextView rxxp_price;
        TextView prirxxp_xiaoliangce;
        public ViewHolder(View itemView) {

            super(itemView);

            rxxp_img=   itemView.findViewById(R.id.rxxp_img);
            rxxp_name = itemView.findViewById(R.id.rxxp_name);
            rxxp_price = itemView.findViewById(R.id.rxxp_price);
            prirxxp_xiaoliangce = itemView.findViewById(R.id.rxxp_xiaoliang);
        }
    }
}
