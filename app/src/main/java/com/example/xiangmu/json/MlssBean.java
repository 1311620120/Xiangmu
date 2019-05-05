package com.example.xiangmu.json;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/16 19:05:34
 * @Description:
 */
public class MlssBean {
    /**
     * result : [{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88,"saleNum":0},{"commodityId":4,"commodityName":"佩佩防晕染眼线液笔","masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/2/1.jpg","price":19,"saleNum":845},{"commodityId":28,"commodityName":"秋季新款女鞋【牛皮】艾斯臣女鞋单鞋蝴蝶结平底单鞋豆豆鞋女加绒保暖小毛球平底女鞋单鞋豆豆鞋女冬女士单鞋毛毛鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/4/1.jpg","price":159,"saleNum":0},{"commodityId":16,"commodityName":"Lara style清洗剂","masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/6/1.jpg","price":12,"saleNum":0},{"commodityId":10,"commodityName":"BYPHASSE蓓昂丝温和清洁净肤保湿卸妆水","masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/7/1.jpg","price":69,"saleNum":0},{"commodityId":24,"commodityName":"百搭小白鞋 女款 时尚舒适板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/7/1.jpg","price":149,"saleNum":0},{"commodityId":14,"commodityName":"美诺MENOW面部刷","masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/4/1.jpg","price":47,"saleNum":0},{"commodityId":8,"commodityName":"Lara style蜜颊润泽腮红","masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/6/1.jpg","price":19,"saleNum":0},{"commodityId":30,"commodityName":"韩版秋冬季甜美蝴蝶结真皮兔毛棉瓢鞋加绒豆豆鞋平底毛毛鞋女单鞋潮","masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/6/1.jpg","price":148,"saleNum":0},{"commodityId":18,"commodityName":"白色经典 秋季新款简约百搭轻便休闲女鞋板鞋小白鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/1/1.jpg","price":79,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 32
         * commodityName : 唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋
         * masterPic : http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg
         * price : 88
         * saleNum : 0
         */

        private String commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
