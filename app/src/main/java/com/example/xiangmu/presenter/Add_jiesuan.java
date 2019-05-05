package com.example.xiangmu.presenter;

import java.io.Serializable;

/**
 * @Auther: L丶Ang
 * @Date: 2019/3/30 16:13:59
 * @Description:
 */
public class Add_jiesuan implements Serializable {
    private int commodityId;
    private String commodityName;
    private int count;
    private String pic;
    private int price;

    @Override
    public String toString() {
        return "Add_jiesuan{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", count=" + count +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                '}';
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
