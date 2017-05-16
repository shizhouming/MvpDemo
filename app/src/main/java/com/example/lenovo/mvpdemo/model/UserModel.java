package com.example.lenovo.mvpdemo.model;

import com.example.lenovo.mvpdemo.presenter.onLoginFinishListener;

/**
 * date: 2017/5/16
 * author: 史洲铭(lenovo)
 * function:
 */

public class UserModel implements IUserModel {
    @Override
    public void login(String Username, String Password, onLoginFinishListener listener) {
        if (!Username.equals("qwer")){
            listener.onUsernameError();
        }else if (!Password.equals("123")){
            listener.onPasswordError();
        }else {
            listener.onSuccess();
        }
    }
}
