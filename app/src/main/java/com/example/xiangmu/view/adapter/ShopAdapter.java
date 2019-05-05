package com.example.xiangmu.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.R;
import com.example.xiangmu.json.SelectBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/19 20:54:49
 * @Description:
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private  Context context;
    List<SelectBean.ResultBean> result;


    public ShopAdapter(Context context, List<SelectBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carilist, null);
        ViewHolder myViewHolder=new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
                    holder.name.setText(result.get(position).getCommodityName());
                    holder.price.setText("￥："+result.get(position).getPrice()+"");
        Glide.with(context).load(result.get(position).getPic()).into(holder.img);
        //复选框  判断是否选中
        holder.checkBox.setChecked(result.get(position).isCheck());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                result.get(position).isCheck();
                if(shopCallBack != null)
                {
                    shopCallBack.GetBack(result);
                }
            }
        });
//        holder.bar.setData(context,selectShopBean.getResult(),position);
//        holder.bar.BarCallBack(new Bar.BarCallBack() {
//            @Override
//            public void callBack() {
//                if(shopCallBack !=null)
//                {
//                    shopCallBack.GetBack(selectShopBean.getResult());
//                }
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return  result.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name,price;
        private final SimpleDraweeView img;

        private final CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.cart_goods_check);
            name = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.text_price);
            img = itemView.findViewById(R.id.image);

        }
    }
    public  interface ShopCallBack{
        public void GetBack(List<SelectBean.ResultBean> bean);

    }
    ShopCallBack shopCallBack;
    public void ShopCallBack(ShopCallBack shopCallBack)
    {
        this.shopCallBack = shopCallBack;
    }
}
