package com.zhchenai.eg.example;

import android.content.Context;
import com.zhchenai.eg.net.ApiException;
import com.zhchenai.eg.net.ReSubscriber;
import com.zhchenai.eg.net.RetrofitApiFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ExamplePresenter implements ExampleController.MVPPresenter {

    ExampleController.MVPView view;
    private Context context;


    public ExamplePresenter(ExampleController.MVPView view, Context context){
        this.context = context;
        this.view = view;
    }

    @Override
    public void list() {

        /**
         * observeOn(AndroidSchedulers.mainThread()) 如果不需要通知主线程，可以注释掉
         */
        view.showProgress("加载中");
        RetrofitApiFactory.createApi(ExampleApi.class,context)
                .list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ReSubscriber<ExampleEntity>() {
                    @Override
                    protected void onError(ApiException ex) {
                        view.hideProgress();
                        view.showError(ex.getMessage());
                    }
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onNext(ExampleEntity entity) {
                        view.hideProgress();
                        if(entity!=null){
                            view.success(entity);
                        }else {
                            view.fail("异常");
                        }
                    }
                });
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onTips(String message) {

    }
}
