package com.example.xiangmu.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.R;
import com.example.xiangmu.json.QuanJson;

import java.text.SimpleDateFormat;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/17 11:41:14
 * @Description:
 */
public class QuanAdapter extends RecyclerView.Adapter<QuanAdapter.ViewHolder> {
    Context context; QuanJson quanJson;
    private  int greatNum;
    public QuanAdapter(Context context, QuanJson quanJson) {
        this.context=context;
        this.quanJson=quanJson;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.quanfragment, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        //头像
        Glide.with(context)
                .load(quanJson.getResult().get(i).getHeadPic())
                .into(holder.circle_image_header);
        //昵称
        holder.circle_text_name.setText(quanJson.getResult().get(i).getNickName());
        //时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String data = simpleDateFormat.format(quanJson.getResult().get(i).getCreateTime());
        holder.circle_text_time.setText(data);

        holder.circle_text_content.setText(quanJson.getResult().get(i).getContent());
        //评价图片
        Glide.with(context)
                .load(quanJson.getResult().get(i).getImage())
                .into(holder.circle_image_content);


        //评价赞数
        holder.circle_text_num.setText(quanJson.getResult().get(i).getGreatNum()+"");
        greatNum = quanJson.getResult().get(i).getGreatNum();
    }


    @Override
    public int getItemCount() {
        return quanJson.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView circle_image_header;
        private ImageView circle_image_content;
        private ImageView circle_image_like;
        private TextView circle_text_name;
        private TextView circle_text_time;
        private TextView circle_text_content;
        private TextView circle_text_num;
        private ImageView item_circle_image_disike;
        public ViewHolder(View itemView) {
            super(itemView);
            circle_image_header=itemView.findViewById(R.id.item_circle_image_header);
            circle_image_content=itemView.findViewById(R.id.item_circle_image_content);
            circle_image_like=itemView.findViewById(R.id.item_circle_image_like);
            circle_text_name=itemView.findViewById(R.id.item_circle_text_name);
            circle_text_time=itemView.findViewById(R.id.item_circle_text_time);
            circle_text_content=itemView.findViewById(R.id.item_circle_text_content);
            circle_text_num=itemView.findViewById(R.id.item_circle_text_num);
            item_circle_image_disike =itemView.findViewById(R.id.item_circle_image_disike);

        }
    }
}
