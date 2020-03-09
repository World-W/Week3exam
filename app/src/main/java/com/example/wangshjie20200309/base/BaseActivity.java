package com.example.wangshjie20200309.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 *王世杰
 * 202200309
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayouResId());
        initView();
        initData();
        mPresenter = initPresenter();
    }
    public P getmPresenter(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.onDeachView();
            mPresenter = null;
        }
    }

    protected abstract P initPresenter();
    protected abstract int getLayouResId();
    protected abstract void initView();
    protected abstract void initData();
}
