package com.qiubo.qiubo.ui.adapters.viewpagers;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.qiubo.qiubo.ui.viewmodels.ItemVM;

import java.util.List;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public class QiuboPagerAdapter extends PagerAdapter {

    private List<ItemVM> mItems;
    private ViewPagerDelegateManager<ItemVM> mDelegateManager;

    public QiuboPagerAdapter() {
        mDelegateManager = new ViewPagerDelegateManager<>();
        mDelegateManager.addDelegate(new SimpleImageDelegate());
        mDelegateManager.addDelegate(new SimpleTextViewDelegate());
        mDelegateManager.addDelegate(new SimpleButtonDelegate());
    }

    @Override
    public int getCount() {
        return mItems != null ? mItems.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return mDelegateManager.instantiateItem(mItems, container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mDelegateManager.destroyViewHolder(position);
        container.removeView((View) object);
    }

    public void setItems(List<ItemVM> items) {
        mItems = items;
        notifyDataSetChanged();
    }
}
