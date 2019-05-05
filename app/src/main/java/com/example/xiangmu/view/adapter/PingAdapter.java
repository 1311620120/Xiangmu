package com.example.xiangmu.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.R;
import com.example.xiangmu.json.SelectBean;
import com.example.xiangmu.view.activity.PingActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/26 10:24:58
 * @Description:
 */
public class PingAdapter extends RecyclerView.Adapter<PingAdapter.ViewHolder> {
    Context context; List<SelectBean.ResultBean> result;
    public PingAdapter(Context context, List<SelectBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pingfragment, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(result.get(position).getCommodityName());
        holder.price.setText("￥："+result.get(position).getPrice()+"");
        Glide.with(context).load(result.get(position).getPic()).into(holder.img);

        holder.pingButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(result.get(position).getCommodityId());
                context.startActivity(new Intent(context,PingActivity.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return result.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name,price;
        private final SimpleDraweeView img;
        private final Button pingButt;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.text_price);
            img = itemView.findViewById(R.id.image);
            pingButt = itemView.findViewById(R.id.pingButt);

        }
    }
}
