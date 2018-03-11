package com.qiubo.qiubo.ui.adapters.viewpagers;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

import com.qiubo.qiubo.ui.adapters.viewpagers.interfaces.IViewPagerDelegate;
import com.qiubo.qiubo.ui.viewmodels.BaseVM;

import java.util.List;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public class ViewPagerDelegateManager<T extends BaseVM> {

    private SparseArrayCompat<IViewPagerDelegate> mDelegateTypes;

    public ViewPagerDelegateManager() {
        mDelegateTypes = new SparseArrayCompat<>();
    }

    public void addDelegate(@NonNull IViewPagerDelegate<List<T>> delegate) {
        if (mDelegateTypes.get(delegate.getDelegateType()) == null) {
            mDelegateTypes.put(delegate.getDelegateType(), delegate);
        } else {
            throw new IllegalArgumentException("Delegate already " + delegate.getDelegateType() + " registered");
        }
    }

    public Object instantiateItem(@NonNull List<T> items, ViewGroup container, int position) {
        int delegateType = items.get(position).getViewType();
        IViewPagerDelegate delegate = mDelegateTypes.get(delegateType);
        if (delegate == null) {
            throw new NullPointerException(
                    "No AdapterDelegate added that matches position=" + position + " in data source");
        }
        return delegate.instantiateItem(items, container, position);
    }

    public void destroyViewHolder(int position) {
        if (mDelegateTypes != null && mDelegateTypes.size() > 0) {
            for (int i = 0; i < mDelegateTypes.size(); i++) {
                int key = mDelegateTypes.keyAt(i);
                IViewPagerDelegate delegate = mDelegateTypes.get(key);
                if (delegate != null) {
                    delegate.destroyViewHolder(position);
                }
            }
        }
    }
}
