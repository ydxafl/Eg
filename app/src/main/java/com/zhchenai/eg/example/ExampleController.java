package com.zhchenai.eg.example;

import com.zhchenai.eg.base.BasePresenter;
import com.zhchenai.eg.base.BaseView;

public interface ExampleController {

    interface MVPView extends BaseView{

        void success(ExampleEntity data);
        void fail(String msg);
    }

   interface MVPPresenter extends BasePresenter {
        void  list();
    }

}
