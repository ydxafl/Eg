
### 超简的MVP + RxJava + Retrofit

 - **ExampleActivity**      *Activity*
 - **ExampleApi**           *接口类*
 - **ExampleBaseData**   *基础数据（就写了一个BASE_URL）*
 - **ExampleController**  *控制器   定义Presenter以及View会调用的方法*
 - **ExampleEntity**    *网络请求返回实体类*
 - **ExamplePresenter**  *操控者（数据请求实现）*

##### 使用

Presenter 业务实现

其中`list()`为`ExampleApi.class`中定义的请求方法（`@GET("weather_mini?city=北京")   Observable<ExampleEntity> list()`;），请求参数为空，返回值为`ExampleEntity`

     	
```java
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
                       // todo something
                        if(entity!=null){
                            view.success(entity);
                        }else {
                            view.fail("异常");
                        }
                    }
                });
```

Activity 调用

```java
	ExamplePresenter presenter = new ExamplePresenter(this,this);
	presenter.list();
```
Activity 请求结果处理

```java
	@Override
    public void success(ExampleEntity data) {
        times ++ ;
        tvShow.setText("地区：" + data.getData().getCity() + "\n" +
                "概述："+ data.getData().getGanmao() + "\n" +
                "温度："+ data.getData().getWendu() + "\n" +
                "昨天："+ data.getData().getYesterday().getType() + "\n" +
                "请求第" + times + "次");
    }

    @Override
    public void fail(String msg) {
        Toast.makeText(this, "失败:" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(String message) {
        //实现loading
    }

    @Override
    public void hideProgress() {
        //取消loading
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "异常：" + message, Toast.LENGTH_SHORT).show();
    }
```
