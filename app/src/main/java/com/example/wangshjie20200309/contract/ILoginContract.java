package com.example.wangshjie20200309.contract;

import com.example.wangshjie20200309.base.IBaseView;

import java.util.HashMap;

/**
 *王世杰
 * 202200309
 */
public interface ILoginContract {
    interface IView extends IBaseView {
        void LoginSuccess(String str);
        void LoginError(String str);

        void RegistSuccess(String str);
        void RegistError(String str);
    }
    interface  IPresenter{
        void doLogin(String url, HashMap<String, String> map);

        void doRegist(String url, HashMap<String, String> map);

    }
    interface  IModel{
        void doLogin(String str, HashMap<String, String> map, ILoginCallBack callBack);
            interface ILoginCallBack{
             void onLoginSuccess(String str);
             void onLogintError(String str);
            }

        void doRegist(String str, HashMap<String, String> map, IRegistCallBack callBack);
        interface IRegistCallBack{
            void onRegistSuccess(String str);
            void onRegistError(String str);
        }
    }
}
