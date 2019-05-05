package com.example.xiangmu.json;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/27 15:57:36
 * @Description:
 */
public class QuanJson {


    /**
     * result : [{"commodityId":19,"content":"救我","createTime":1554829149000,"greatNum":2,"headPic":"http://172.17.8.100/images/small/head_pic/2019-04-06/20190406202927.jpg","id":907,"image":"http://172.17.8.100/images/small/circle_pic/2019-04-09/7508120190409115909.jpg","nickName":"海蓝时见鲸","userId":476,"whetherGreat":2},{"commodityId":2,"content":"?hao","createTime":1554738983000,"greatNum":4,"headPic":"http://172.17.8.100/images/small/head_pic/2019-04-08/20190408112636.png","id":901,"image":"","nickName":"千千","userId":3119,"whetherGreat":2},{"commodityId":2,"content":"?hao","createTime":1554738749000,"greatNum":3,"headPic":"http://172.17.8.100/images/small/head_pic/2019-04-08/20190408112636.png","id":900,"image":"","nickName":"千千","userId":3119,"whetherGreat":2},{"commodityId":2,"content":"?hao","createTime":1554738724000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-04-08/20190408112636.png","id":899,"image":"","nickName":"千千","userId":3119,"whetherGreat":2},{"commodityId":2,"content":"?hao","createTime":1554738688000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-04-08/20190408112636.png","id":898,"image":"","nickName":"千千","userId":3119,"whetherGreat":2},{"commodityId":1,"content":"??????????","createTime":1554737799000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":897,"image":"http://172.17.8.100/images/small/circle_pic/2019-04-08/1568320190408103639.png","nickName":"ZS_N6z91","userId":2675,"whetherGreat":2},{"commodityId":1,"content":"??????????","createTime":1554737637000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":895,"image":"http://172.17.8.100/images/small/circle_pic/2019-04-08/4806320190408103357.png","nickName":"ZS_N6z91","userId":2675,"whetherGreat":2},{"commodityId":1,"content":"??????????","createTime":1554737381000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":889,"image":"http://172.17.8.100/images/small/circle_pic/2019-04-08/3596020190408102941.png","nickName":"ZS_N6z91","userId":2675,"whetherGreat":2},{"commodityId":1,"content":"??????????","createTime":1554737330000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":888,"image":"http://172.17.8.100/images/small/circle_pic/2019-04-08/9726520190408102850.png","nickName":"ZS_N6z91","userId":2675,"whetherGreat":2},{"commodityId":1,"content":"??????????","createTime":1554736595000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-04-08/20190408101707.jpg","id":886,"image":"http://172.17.8.100/images/small/circle_pic/2019-04-08/2735420190408101635.jpg","nickName":"QT_5T522","userId":3139,"whetherGreat":2}]
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
         * commodityId : 19
         * content : 救我
         * createTime : 1554829149000
         * greatNum : 2
         * headPic : http://172.17.8.100/images/small/head_pic/2019-04-06/20190406202927.jpg
         * id : 907
         * image : http://172.17.8.100/images/small/circle_pic/2019-04-09/7508120190409115909.jpg
         * nickName : 海蓝时见鲸
         * userId : 476
         * whetherGreat : 2
         */

        private int commodityId;
        private String content;
        private long createTime;
        private int greatNum;
        private String headPic;
        private int id;
        private String image;
        private String nickName;
        private int userId;
        private int whetherGreat;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
