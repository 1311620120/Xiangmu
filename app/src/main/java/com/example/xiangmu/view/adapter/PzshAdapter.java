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
import com.example.xiangmu.json.ShowJson;
import com.example.xiangmu.view.activity.XiangQAdapter;

import org.greenrobot.eventbus.EventBus;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 09:00:09
 * @Description:
 */
public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.ViewHolder> {
    Context context; ShowJson.ResultBean bean;
    public PzshAdapter(Context context, ShowJson.ResultBean bean) {
        this.context=context;
        this.bean=bean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_fragment_rxxp_pzss, null);
        PzshAdapter.ViewHolder viewHolder = new PzshAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(bean.getPzsh().getCommodityList().get(i).getCommodityName());
        viewHolder.price.setText("价格："+bean.getPzsh().getCommodityList().get(i).getPrice());
        Glide.with(context)
                .load(bean.getPzsh()
                        .getCommodityList().get(i).getMasterPic())
                .into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Pid = bean.getPzsh().getCommodityList().get(i).getCommodityId();
                Log.e("tag",""+Pid);
                EventBus.getDefault().postSticky(Pid);
                context.startActivity(new Intent(context,XiangQAdapter.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return bean.getPzsh().getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public ViewHolder(View itemView) {

            super(itemView);

            img=   itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
