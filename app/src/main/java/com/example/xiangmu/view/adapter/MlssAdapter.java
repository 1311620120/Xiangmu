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
 * @Date: 2019/4/12 09:00:28
 * @Description:
 */
public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.ViewHolder> {
    Context context; ShowJson.ResultBean bean;

    public MlssAdapter(Context context, ShowJson.ResultBean bean) {
        this.context=context;
        this.bean=bean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_fragment_mlss, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
         viewHolder.name.setText(bean.getMlss().getCommodityList().get(i).getCommodityName());
        viewHolder.pirce.setText("价格："+bean.getMlss().getCommodityList().get(i).getPrice());
        Glide.with(context)


                .load(bean.getMlss()
                        .getCommodityList().get(i).getMasterPic())
                .into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(bean.getMlss().getCommodityList().get(i).getCommodityId());
                context.startActivity(new Intent(context,XiangQAdapter.class));
            }
        });
    }



    @Override
    public int getItemCount() {
        return bean.getMlss().getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView pirce;
        public ViewHolder(View itemView) {

            super(itemView);

            img=   itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            pirce = itemView.findViewById(R.id.pirce);
        }
    }
}
