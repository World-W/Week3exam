package com.example.wangshjie20200309.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangshjie20200309.R;
import com.example.wangshjie20200309.base.BaseActivity;
import com.example.wangshjie20200309.base.BasePresenter;
import com.example.wangshjie20200309.bean.LoginBean;
import com.example.wangshjie20200309.bean.RegistBean;
import com.example.wangshjie20200309.contract.ILoginContract;
import com.example.wangshjie20200309.presenter.ILoginPresenter;
import com.example.wangshjie20200309.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *王世杰
 * 202200309
 */
public class MainActivity extends BaseActivity implements ILoginContract.IView, View.OnClickListener {

    private TextView forget;
    private CheckBox check;
    private Button bt2;
    private Button bt1;
    private ILoginPresenter loginPresenter;
    String Loginurl = "http://mobile.bwstudent.com/small/user/v1/login";
    String Registurl = "http://mobile.bwstudent.com/small/user/v1/register";
    private EditText et1;
    private EditText et2;
    private String phone;
    private String pwd;

    @Override
    protected BasePresenter initPresenter() {
        return new ILoginPresenter(this);
    }

    @Override
    protected int getLayouResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        check = findViewById(R.id.check);
        forget = findViewById(R.id.forget);
    }

    @Override
    protected void initData() {

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        loginPresenter = new ILoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                doRegist();
                break;
            case R.id.bt2 :
                doLogin();
                break;
        }
    }

    private void doLogin() {
        phone = et1.getText().toString();
        pwd = et2.getText().toString();
        boolean netWork = VolleyUtils.getInstance().getNetWork(this);
        if(netWork){
            if(!TextUtils.isEmpty(phone) && getphone(phone)){
                if(!TextUtils.isEmpty(phone)){
                    HashMap<String,String> map = new HashMap<>();
                    map.put("phone",phone);
                    map.put("pwd",pwd);

                    loginPresenter.doLogin(Loginurl,map);
                }else{
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "手机号输入有误", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "网络连接失败", Toast.LENGTH_SHORT).show();
        }
    }

    private void doRegist() {
        phone = et1.getText().toString();
        pwd = et2.getText().toString();
        boolean netWork = VolleyUtils.getInstance().getNetWork(this);
        if(netWork){
            if(!TextUtils.isEmpty(phone) && getphone(phone)){
                if(!TextUtils.isEmpty(pwd)){
                    HashMap<String,String> map = new HashMap<>();
                    map.put("phone",phone);
                    map.put("pwd",pwd);

                    loginPresenter.doRegist(Registurl,map);
                }else{
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "手机号输入有误", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "网络连接失败", Toast.LENGTH_SHORT).show();
        }
    }
    public  boolean getphone(String str){
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
        Pattern pattern = Pattern.compile(telRegex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    @Override
    public void LoginSuccess(String str) {
        Log.i("xxx",str);
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(str, LoginBean.class);
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        if(loginBean.getMessage().equals("登录成功")){
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

    @Override
    public void LoginError(String str) {

    }

    @Override
    public void RegistSuccess(String str) {
        Log.i("xxx",str);
        Gson gson = new Gson();
        RegistBean registBean = gson.fromJson(str, RegistBean.class);
        Toast.makeText(this, ""+registBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RegistError(String str) {

    }
}
