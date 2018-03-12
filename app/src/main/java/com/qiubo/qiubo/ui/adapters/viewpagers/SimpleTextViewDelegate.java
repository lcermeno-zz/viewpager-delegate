package com.qiubo.qiubo.ui.adapters.viewpagers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qiubo.qiubo.R;
import com.qiubo.qiubo.ui.viewmodels.ContentVM;

import java.util.List;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public class SimpleTextViewDelegate extends ViewPagerDelegate<ContentVM> {

    public static final int DELEGATE_TYPE = 128;

    @Override
    public int getDelegateType() {
        return DELEGATE_TYPE;
    }

    @Override
    public Object instantiateItem(List<ContentVM> items, ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_simple_text_view, container, false);
        container.addView(itemView);
        return itemView;
    }

    @Override
    void onBindViewHolder(ContentVM item, Object holder) {

    }

    @Override
    Object buildViewHolder(View itemView) {
        return null;
    }
}
