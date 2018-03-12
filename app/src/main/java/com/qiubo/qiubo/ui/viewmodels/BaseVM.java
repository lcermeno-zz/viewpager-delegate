package com.qiubo.qiubo.ui.viewmodels;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public abstract class BaseVM {
    private int mViewType;

    public int getViewType() {
        return mViewType;
    }

    public void setViewType(int viewType) {
        mViewType = viewType;
    }
}
