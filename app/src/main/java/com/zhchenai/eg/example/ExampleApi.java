package com.zhchenai.eg.example;

import retrofit2.http.GET;
import rx.Observable;

public interface ExampleApi {

    //  url 不该这么拼接……  请查看retrofit2使用方法
    //  参考：https://www.jianshu.com/p/7687365aa946
    @GET("weather_mini?city=北京")
    Observable<ExampleEntity> list();
}
