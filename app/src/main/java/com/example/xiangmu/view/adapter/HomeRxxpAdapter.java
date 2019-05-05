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
import com.example.xiangmu.json.RxxpBean;
import com.example.xiangmu.view.activity.XiangQAdapter;

import org.greenrobot.eventbus.EventBus;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/16 19:48:08
 * @Description:
 */
public class HomeRxxpAdapter extends RecyclerView.Adapter<HomeRxxpAdapter.ViewHolder> {
    Context context; RxxpBean rxxpBean;
    public HomeRxxpAdapter(Context context, RxxpBean rxxpBean) {
        this.context=context;
        this.rxxpBean=rxxpBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_rxxp, null);
        HomeRxxpAdapter.ViewHolder viewHolder = new HomeRxxpAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       holder.rxxp_name.setText(rxxpBean.getResult().get(position).getCommodityName());
        holder.rxxp_price.setText("价格："+rxxpBean.getResult().get(position).getPrice()+"");
        holder.prirxxp_xiaoliangce.setText("已售"+rxxpBean.getResult().get(position).getSaleNum()+"");
        Glide.with(context)
                .load(rxxpBean.getResult().get(position).getMasterPic())
                .into(holder.rxxp_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().postSticky(rxxpBean.getResult().get(position).getCommodityId());
                context.startActivity(new Intent(context,XiangQAdapter.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return rxxpBean.getResult().size();
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
