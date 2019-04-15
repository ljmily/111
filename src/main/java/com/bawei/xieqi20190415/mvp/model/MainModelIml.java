package com.bawei.xieqi20190415.mvp.model;

import com.bawei.xieqi20190415.net.OkHttpUtils;

import okhttp3.FormBody;

/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/4/15 9:16
 * @Description：描述信息
 */
public class MainModelIml implements MainModel {
    @Override
    public void doLogin(String phone, String pwd, final CallBackListener callBackListener) {
        String url = "http://172.17.8.100/small/user/v1/login";
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("phone",phone);
        builder.add("pwd",pwd);
        new OkHttpUtils().post(url,builder).result(new OkHttpUtils.HttpListener() {
            @Override
            public void success(String data) {
                callBackListener.success(data);
            }

            @Override
            public void fail(String error) {
                callBackListener.fail(error);
            }
        });
    }

    @Override
    public void doRegiset(String phone, String pwd, final CallBackListener callBackListener) {
        String url = "http://172.17.8.100/small/user/v1/register";
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("phone",phone);
        builder.add("pwd",pwd);
        new OkHttpUtils().post(url,builder).result(new OkHttpUtils.HttpListener() {
            @Override
            public void success(String data) {
                callBackListener.success(data);
            }

            @Override
            public void fail(String error) {
                callBackListener.fail(error);
            }
        });
    }
}
