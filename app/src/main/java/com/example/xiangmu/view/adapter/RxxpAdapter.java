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
import com.example.xiangmu.json.ShowJson;
import com.example.xiangmu.view.activity.XiangQAdapter;

import org.greenrobot.eventbus.EventBus;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 08:57:53
 * @Description:
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    Context context; ShowJson.ResultBean bean;
    public RxxpAdapter(Context context, ShowJson.ResultBean bean) {
        this.context=context;
        this.bean=bean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_fragment_rxxp_pzss, null);
        RxxpAdapter.ViewHolder viewHolder = new RxxpAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(bean.getRxxp().getCommodityList().get(i).getCommodityName());
        viewHolder.price.setText("价格："+bean.getRxxp().getCommodityList().get(i).getPrice());
        Glide.with(context)
                .load(bean.getRxxp()
                        .getCommodityList().get(i).getMasterPic())
                .into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Rid = bean.getRxxp().getCommodityList().get(i).getCommodityId();
                EventBus.getDefault().postSticky(Rid);
                context.startActivity(new Intent(context,XiangQAdapter.class));
            }
        });
    }



    @Override
    public int getItemCount() {
        return bean.getRxxp().getCommodityList().size();
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
