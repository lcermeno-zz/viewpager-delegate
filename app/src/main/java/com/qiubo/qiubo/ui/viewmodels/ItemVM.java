package com.qiubo.qiubo.ui.viewmodels;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public class ItemVM extends BaseVM {
    private String mId;
    private int mResourceId;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public void setResourceId(int resourceId) {
        mResourceId = resourceId;
    }
}
