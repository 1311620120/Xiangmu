package com.example.xiangmu.model;

import com.example.xiangmu.json.AddCarBean;
import com.example.xiangmu.json.BannerJson;
import com.example.xiangmu.json.LoginBean;
import com.example.xiangmu.json.MlssBean;
import com.example.xiangmu.json.PzshBean;
import com.example.xiangmu.json.QuanJson;
import com.example.xiangmu.json.RegBean;
import com.example.xiangmu.json.RxxpBean;
import com.example.xiangmu.json.SelectBean;
import com.example.xiangmu.json.ShowJson;
import com.example.xiangmu.json.SouBean;
import com.example.xiangmu.json.XiangQBean;


import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/18 14:13:54
 * @Description:
 */


//public  static  final  String RXXP="http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1003&page=1&count=10";
//public  static  final  String MLSS="http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1002&page=1&count=10";
//public  static  final  String PZSH="http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1004&page=1&count=10";
//public  static  final  String SHU="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword";
 public  interface Api {
     //登录
     @POST("small/user/v1/login")

     Observable<LoginBean> Login(@QueryMap HashMap<String,String> hashMap);
     //注册
    @POST("small/user/v1/register")

    Observable<RegBean> Reg(@QueryMap HashMap<String,String>hashMap);
    //首页
    @GET("small/commodity/v1/commodityList")
    Observable<ShowJson> show();
    //轮播图
    @GET("small/commodity/v1/bannerShow")
    Observable<BannerJson> banner();
    //详情
    @GET("small/commodity/v1/findCommodityDetailsById")
    Observable<XiangQBean> XiangQ(@Query("commodityId")String id);
    //圈子
    @GET("small/circle/v1/findCircleList")
    Observable<QuanJson> Quan(@Query("page")int page,@Query("count")int count);
    //搜索
    @GET("small/commodity/v1/findCommodityByKeyword")
    Observable<SouBean> Sou(@Query("keyword")String keyword,@Query("page") int page,@Query("count") int count);
    //Rxxp
    @GET("small/commodity/v1/findCommodityListByLabel")
    Observable<RxxpBean> Rxxp(@Query("labelId")String labelId ,@Query("page") int page,@Query("count") int count);
    //mlss
    @GET("small/commodity/v1/findCommodityListByLabel")
    Observable<MlssBean> Mlss(@Query("labelId")String labelId ,@Query("page") int page,@Query("count") int count);
    //pzsh
    @GET("small/commodity/v1/findCommodityListByLabel")
    Observable<PzshBean> Pzsh(@Query("labelId")String labelId ,@Query("page") int page,@Query("count") int count);
    //查询购物车
    @GET("small/order/verify/v1/findShoppingCart")
   Observable<SelectBean> Select(@Query("userId")int userId , @Query("sessionId") String sessionId);
    //添加购物车
    @PUT("small/order/verify/v1/syncShoppingCart")
    @FormUrlEncoded
    Observable<AddCarBean> AddCar(@Query("userId")int userId ,@Query("sessionId") String sessionId,@Field("data")String data);

 }
