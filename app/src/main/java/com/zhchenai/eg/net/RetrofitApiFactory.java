package com.zhchenai.eg.net;

import android.content.Context;
import com.zhchenai.eg.example.ExampleBaseData;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * 类描述：Api 工厂类
 */
public class RetrofitApiFactory {

    /**
     * OkhttpClient
     */
    private static OkHttpClient mOkHttpClient;

    /**
     * 代理接口构建类
     */
    private static Retrofit retrofit;

    /**
     * Http连接超时
     */
    private static int CONNECT_TIMEOUT = 20;

    /**
     * Http 读取超时
     */
    private static int READ_TIMEOUT = 20;

    /**
     * Http 写入超时
     */
    private static int WRITE_TIMEOUT = 20;

    /**
     * 缓存大小
     */
    private static int CACHE_SIZE = 10 * 1024 * 1024;

    private static Context context;




    /**
     * 构建 Retrofit
     */
    private static void buildRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(ExampleBaseData.BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//对转换后的数据进行再包装
                .build();
    }

    /**
     * OkHttpClient 请求配置
     */
    private static void buildOkHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient()
                .newBuilder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        Cache cache = new Cache(context.getCacheDir(), CACHE_SIZE);
        builder.cache(cache);
        //加入日志拦截器，请求头添加拦截器
        mOkHttpClient = builder.addInterceptor(logging).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        }).build();
    }


    /**
     * 创建不同的Api 接口对象
     * @param serviceClass
     * @param <T>
     * @return
     */
    public static <T> T createApi(Class<T> serviceClass, Context contextl) {

        context = contextl;
        buildOkHttpClient();
        buildRetrofit();
        return retrofit.create(serviceClass);
    }



}
