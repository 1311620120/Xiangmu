package com.example.xiangmu.json;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/18 15:28:06
 * @Description:
 */
public class XiangQBean {
    /**
     * result : {"categoryId":"1001004002","categoryName":"帆布鞋","commentNum":12,"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","describe":"黑白,35码","details":"<div class=\"dc-img\">\r\n    <div class=\"dc-img-detail\">\r\n                        <div class=\"img-6xx-bg\">\r\n            <img src=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/156/a04c138d-503c-42b2-a486-73fc1a1ef976.jpg\" class=\"J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/156/a04c138d-503c-42b2-a486-73fc1a1ef976.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/123/cbc69588-d34f-4ba0-be6e-73ee0ead7412.jpg\" class=\"J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/123/cbc69588-d34f-4ba0-be6e-73ee0ead7412.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://s2.vipstatic.com/img/share/blank.png\" class=\"lazy J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/38/a215b28f-34bd-448a-93a1-136a7ed69994.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://s2.vipstatic.com/img/share/blank.png\" class=\"lazy J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/83/fd1527bc-c704-4557-a90f-d4a7fcea7fed.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://s2.vipstatic.com/img/share/blank.png\" class=\"lazy J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/129/b1539634-bbf4-4e23-9dc5-c095329e26cb.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://s2.vipstatic.com/img/share/blank.png\" class=\"lazy J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/48/6fd75408-2cd6-4d1b-9d7e-18459fb34496.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://s2.vipstatic.com/img/share/blank.png\" class=\"lazy J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/111/2b9ed0a0-f3aa-4edf-81de-fb6dd0bfbaf5.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://s2.vipstatic.com/img/share/blank.png\" class=\"lazy J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/81/fbbc3f26-59a5-4ee2-a1c4-6cebaa7c1bd5.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://s2.vipstatic.com/img/share/blank.png\" class=\"lazy J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/166/4a6e7534-f06d-41e2-8aad-8fa5ec108b0e.jpg\">\r\n        <\/div>\r\n                <div class=\"img-6xx-bg\">\r\n            <img src=\"http://s2.vipstatic.com/img/share/blank.png\" class=\"lazy J-mer-bigImg\" data-original=\"http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/195/6f7eb091-997e-4848-9d08-5d7fad777d69.jpg\">\r\n        <\/div>\r\n            <\/div>\r\n    <div class=\"dc-img-con\">\r\n            <\/div>\r\n    <div class=\"dc-txt-con\">\r\n            <\/div>\r\n<\/div>","picture":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/2.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/3.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/4.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/5.jpg","price":88,"saleNum":0,"stock":9999,"weight":1}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * categoryId : 1001004002
         * categoryName : 帆布鞋
         * commentNum : 12
         * commodityId : 32
         * commodityName : 唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋
         * describe : 黑白,35码
         * details : <div class="dc-img">
         <div class="dc-img-detail">
         <div class="img-6xx-bg">
         <img src="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/156/a04c138d-503c-42b2-a486-73fc1a1ef976.jpg" class="J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/156/a04c138d-503c-42b2-a486-73fc1a1ef976.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/123/cbc69588-d34f-4ba0-be6e-73ee0ead7412.jpg" class="J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/123/cbc69588-d34f-4ba0-be6e-73ee0ead7412.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/38/a215b28f-34bd-448a-93a1-136a7ed69994.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/83/fd1527bc-c704-4557-a90f-d4a7fcea7fed.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/129/b1539634-bbf4-4e23-9dc5-c095329e26cb.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/48/6fd75408-2cd6-4d1b-9d7e-18459fb34496.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/111/2b9ed0a0-f3aa-4edf-81de-fb6dd0bfbaf5.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/81/fbbc3f26-59a5-4ee2-a1c4-6cebaa7c1bd5.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/166/4a6e7534-f06d-41e2-8aad-8fa5ec108b0e.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg3.com/upload/merchandise/pdcvis/2018/09/17/195/6f7eb091-997e-4848-9d08-5d7fad777d69.jpg">
         </div>
         </div>
         <div class="dc-img-con">
         </div>
         <div class="dc-txt-con">
         </div>
         </div>
         * picture : http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/2.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/3.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/4.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/5.jpg
         * price : 88
         * saleNum : 0
         * stock : 9999
         * weight : 1
         */

        private String categoryId;
        private String categoryName;
        private int commentNum;
        private String commodityId;
        private String commodityName;
        private String describe;
        private String details;
        private String picture;
        private String price;
        private int saleNum;
        private int stock;
        private int weight;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "categoryId='" + categoryId + '\'' +
                    ", categoryName='" + categoryName + '\'' +
                    ", commentNum=" + commentNum +
                    ", commodityId=" + commodityId +
                    ", commodityName='" + commodityName + '\'' +
                    ", describe='" + describe + '\'' +
                    ", details='" + details + '\'' +
                    ", picture='" + picture + '\'' +
                    ", price=" + price +
                    ", saleNum=" + saleNum +
                    ", stock=" + stock +
                    ", weight=" + weight +
                    '}';
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

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

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
