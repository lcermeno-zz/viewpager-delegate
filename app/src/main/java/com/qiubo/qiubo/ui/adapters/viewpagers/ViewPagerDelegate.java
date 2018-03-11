package com.qiubo.qiubo.ui.adapters.viewpagers;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;

import com.qiubo.qiubo.ui.adapters.viewpagers.interfaces.IViewPagerDelegate;

import java.util.List;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public abstract class ViewPagerDelegate<T> implements IViewPagerDelegate<List<T>> {

    protected SparseArrayCompat<Object> mViewHolders;

    public ViewPagerDelegate() {
        mViewHolders = new SparseArrayCompat<>();
    }

    @NonNull
    protected void onCreateViewHolder(View itemView, int position, T item) {
        Object viewHolder = mViewHolders.get(position);

        if (viewHolder == null) {
            viewHolder = buildViewHolder(itemView);
            mViewHolders.put(position, viewHolder);
        }
        onBindViewHolder(item, viewHolder);
    }

    abstract void onBindViewHolder(T item, Object holder);

    abstract Object buildViewHolder(View itemView);

    public void destroyViewHolder(int position) {
        mViewHolders.remove(position);
    }
}
