package com.qiubo.qiubo.ui.adapters.viewpagers.interfaces;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public interface IViewPagerDelegate<T> {

    int getDelegateType();

    boolean isForViewType(@NonNull T items, int position);

    Object instantiateItem(T items, ViewGroup container, int position);

    void destroyViewHolder(int position);
}