package com.example.wangshjie20200309.presenter;


import com.example.wangshjie20200309.base.BasePresenter;
import com.example.wangshjie20200309.base.IBaseView;
import com.example.wangshjie20200309.contract.ILoginContract;
import com.example.wangshjie20200309.model.ILoginModel;

import java.util.HashMap;

/**
 *王世杰
 * 202200309
 */
public class ILoginPresenter extends BasePresenter implements ILoginContract.IPresenter {
    ILoginModel mModel;
    public ILoginPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new ILoginModel();
    }

    @Override
    public void doLogin(String url, HashMap<String, String> map) {
        mModel.doLogin(url, map, new ILoginContract.IModel.ILoginCallBack() {
            @Override
            public void onLoginSuccess(String str) {
                IBaseView iBaseView = getView();
                if(iBaseView!=null && iBaseView instanceof ILoginContract.IView){
                    ILoginContract.IView iView = (ILoginContract.IView) iBaseView;
                    iView.LoginSuccess(str);
                }
            }

            @Override
            public void onLogintError(String str) {
                IBaseView iBaseView = getView();
                if(iBaseView!=null && iBaseView instanceof ILoginContract.IView){
                    ILoginContract.IView iView = (ILoginContract.IView) iBaseView;
                    iView.LoginError(str);
                }
            }
        });
    }

    @Override
    public void doRegist(String url, HashMap<String, String> map) {
        mModel.doRegist(url, map, new ILoginContract.IModel.IRegistCallBack() {
            @Override
            public void onRegistSuccess(String str) {
                IBaseView iBaseView = getView();
                if(iBaseView!=null && iBaseView instanceof ILoginContract.IView){
                    ILoginContract.IView iView = (ILoginContract.IView) iBaseView;
                    iView.RegistSuccess(str);
                }
            }

            @Override
            public void onRegistError(String str) {
                IBaseView iBaseView = getView();
                if(iBaseView!=null && iBaseView instanceof ILoginContract.IView){
                    ILoginContract.IView iView = (ILoginContract.IView) iBaseView;
                    iView.RegistError(str);
                }
            }
        });
    }
}
