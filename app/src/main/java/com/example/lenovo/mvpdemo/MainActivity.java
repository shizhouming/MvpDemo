package com.example.lenovo.mvpdemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.mvpdemo.presenter.LoginPresenterImpl;
import com.example.lenovo.mvpdemo.view.loginView;

public class MainActivity extends Activity implements loginView, View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button btn;
    private LoginPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
        mPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            setUsernameError();
            return;
        }

        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            setPasswordError();
            return;
        }

        // TODO validate success, do something
        mPresenter.validateCredatials(usernameString,passwordString);

    }

    @Override
    public void setUsernameError() {
        username.setError("用户名错误");
    }

    @Override
    public void setPasswordError() {
        password.setError("密码错误");
    }

    @Override
    public void navitageToHome() {
        Toast.makeText(this,"login success",Toast.LENGTH_SHORT).show();
    }




}
