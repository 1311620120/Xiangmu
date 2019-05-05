package com.example.xiangmu.json;

/**
 * @Auther: L丶Ang
 * @Date: 2019/3/27 19:34:42
 * @Description:
 */
public class TongBean {
    private String commodityId;
    private int count;
    private String amount;

    public TongBean() {
         this.commodityId=commodityId;
         this.count=count;

    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
