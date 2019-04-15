package com.bawei.xieqi20190415.mvp.presenter;

import com.bawei.xieqi20190415.mvp.model.MainModel;
import com.bawei.xieqi20190415.mvp.view.MainView;

/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/4/15 9:18
 * @Description：描述信息
 */
public class MainPresenterIml implements MainPresenter, MainModel.CallBackListener {
    private MainModel mainModel;
    private MainView mainView;

    public MainPresenterIml(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void doLogin(String phone, String pwd) {
        mainModel.doLogin(phone,pwd,this);
    }

    @Override
    public void doRegiset(String phone, String pwd) {
        mainModel.doRegiset(phone,pwd,this);
    }

    @Override
    public void success(String data) {
        mainView.success(data);
    }

    @Override
    public void fail(String error) {
        mainView.fail(error);
    }
}
