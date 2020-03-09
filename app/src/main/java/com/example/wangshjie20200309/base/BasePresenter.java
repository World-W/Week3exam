package com.example.wangshjie20200309.base;

import java.lang.ref.WeakReference;

/**
 *王世杰
 * 202200309
 */
public abstract class BasePresenter<V extends IBaseView> {
    WeakReference<V> mWeakReference;
    public BasePresenter(V v){
        mWeakReference = new WeakReference<>(v);
        initModel();
    }

    protected abstract void initModel();
    public V getView(){
        if (mWeakReference!=null){
            return mWeakReference.get();
        }
        return null;
    }
    protected void onDeachView(){
        if(mWeakReference!=null){
            mWeakReference.clear();
            mWeakReference=null;
        }
    }
}
