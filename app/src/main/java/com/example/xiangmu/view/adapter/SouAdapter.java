package com.example.xiangmu.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.R;
import com.example.xiangmu.json.SouBean;
import com.example.xiangmu.view.activity.XiangQAdapter;

import org.greenrobot.eventbus.EventBus;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/17 00:52:21
 * @Description:
 */
public class SouAdapter extends RecyclerView.Adapter<SouAdapter.ViewHolder> {
    Context context; SouBean souBean;
    public SouAdapter(Context context, SouBean souBean) {
        this.context=context;
        this.souBean=souBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_rxxp, null);
        SouAdapter.ViewHolder viewHolder = new SouAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.rxxp_name.setText(souBean.getResult().get(position).getCommodityName());
        holder.rxxp_price.setText("价格："+souBean.getResult().get(position).getPrice()+"");
        holder.prirxxp_xiaoliangce.setText("已售"+souBean.getResult().get(position).getSaleNum()+"");
        Glide.with(context)
                .load(souBean.getResult().get(position).getMasterPic())
                .into(holder.rxxp_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commodityId = souBean.getResult().get(position).getCommodityId();
                Log.e("zzz",""+commodityId);
                EventBus.getDefault().postSticky(commodityId);
                context.startActivity(new Intent(context,XiangQAdapter.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return souBean.getResult().size();
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
