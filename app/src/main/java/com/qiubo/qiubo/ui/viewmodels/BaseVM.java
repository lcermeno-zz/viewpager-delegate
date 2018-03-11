package com.qiubo.qiubo.ui.viewmodels;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public abstract class BaseVM {
    private int viewType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
