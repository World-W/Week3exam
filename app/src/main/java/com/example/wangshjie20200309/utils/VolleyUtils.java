package com.example.wangshjie20200309.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.wangshjie20200309.base.App;

import java.util.HashMap;
import java.util.Map;

/**
 *王世杰
 * 202200309
 */
public class VolleyUtils {
    RequestQueue mQueue;
    private VolleyUtils(){
        mQueue = Volley.newRequestQueue(App.getContext());
    }
    private static  class SingleInstacne{
        private static final VolleyUtils INSTANCE = new VolleyUtils();
    }
    public static VolleyUtils getInstance(){
        return SingleInstacne.INSTANCE;
    }
    //接口回调
    public interface CallBack{
        void onSuccess(String json);
        void onError(String msg);
    }
    //判断网络状态
    public boolean getNetWork(Context context){
        ConnectivityManager cm  = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        if(activeNetworkInfo!=null){
            return true;
        }
        return false;
    }
    //post请求
    public void doPost(String url, final HashMap<String,String> map, final CallBack callBack){
        StringRequest stringRequest  = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams()  {
                return map;
            }
        };
        mQueue.add(stringRequest);
    }
    //get请求
    public void doGet(String url, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }
}
