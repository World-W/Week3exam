package com.example.wangshjie20200309.model;


import com.example.wangshjie20200309.contract.ILoginContract;
import com.example.wangshjie20200309.utils.VolleyUtils;

import java.util.HashMap;

/**
 *王世杰
 * 202200309
 */
public class ILoginModel implements ILoginContract.IModel {

    @Override
    public void doLogin(String str, HashMap<String, String> map, final ILoginCallBack callBack) {
        VolleyUtils.getInstance().doPost(str, map, new VolleyUtils.CallBack() {
            @Override
            public void onSuccess(String json) {
                callBack.onLoginSuccess(json);
            }

            @Override
            public void onError(String msg) {
                callBack.onLogintError(msg);
            }
        });
    }

    @Override
    public void doRegist(String str, HashMap<String, String> map, final IRegistCallBack callBack) {
        VolleyUtils.getInstance().doPost(str, map, new VolleyUtils.CallBack() {
            @Override
            public void onSuccess(String json) {
                callBack.onRegistSuccess(json);
            }

            @Override
            public void onError(String msg) {
                callBack.onRegistError(msg);
            }
        });
    }
}
