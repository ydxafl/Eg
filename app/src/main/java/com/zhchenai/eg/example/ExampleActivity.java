package com.zhchenai.eg.example;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.zhchenai.eg.R;
import com.zhchenai.eg.base.BaseActivity;


public class ExampleActivity extends BaseActivity implements ExampleContact.MVPView {

    private TextView tvShow;

    private Button btGet;

    private ExamplePresenter presenter;

    private int times = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void initBind() {
    }

    @Override
    protected void initUI() {
        tvShow = findViewById(R.id.tv_show);
        btGet = findViewById(R.id.bt_get);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.list();
            }
        });
    }

    @Override
    protected void initData() {
        presenter = new ExamplePresenter(this,this);
    }


    @SuppressLint("SetTextI18n")
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
}
