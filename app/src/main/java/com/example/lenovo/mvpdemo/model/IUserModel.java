package com.example.lenovo.mvpdemo.model;

import com.example.lenovo.mvpdemo.presenter.onLoginFinishListener;

/**
 * date: 2017/5/16
 * author: 史洲铭(lenovo)
 * function:
 */

public interface IUserModel {

    void login(String Username, String Password, onLoginFinishListener listener);

}
