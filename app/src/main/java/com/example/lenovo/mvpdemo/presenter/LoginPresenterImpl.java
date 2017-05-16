package com.example.lenovo.mvpdemo.presenter;

import com.example.lenovo.mvpdemo.model.IUserModel;
import com.example.lenovo.mvpdemo.model.UserModel;
import com.example.lenovo.mvpdemo.view.loginView;


/**
 * date: 2017/5/16
 * author: 史洲铭(lenovo)
 * function:
 */

public class LoginPresenterImpl implements onLoginFinishListener,loginPresenter {
    private loginView mloginView;
    private IUserModel loginModel;

    public LoginPresenterImpl(loginView loginView) {
        this.mloginView = loginView;
        this.loginModel = new UserModel();
    }
    @Override
    public void validateCredatials(String Username, String Password) {
        loginModel.login(Username, Password,this);
    }

    @Override
    public void onDestroy() {
        mloginView = null;
    }

    @Override
    public void onUsernameError() {
        if (mloginView != null) {
            mloginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (mloginView != null) {
            mloginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mloginView != null) {
            mloginView.navitageToHome();
        }
    }
}
