package com.bawei.xieqi20190415.mvp.model;

/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/4/15 9:13
 * @Description：描述信息
 */
public interface MainModel {
    interface CallBackListener{
        void success(String data);
        void fail(String error);
    }
    void doLogin(String phone,String pwd,CallBackListener callBackListener);
    void doRegiset(String phone,String pwd,CallBackListener callBackListener);
}
