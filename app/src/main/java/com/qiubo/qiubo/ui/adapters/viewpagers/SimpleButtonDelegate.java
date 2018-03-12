package com.qiubo.qiubo.ui.adapters.viewpagers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qiubo.qiubo.R;
import com.qiubo.qiubo.ui.viewholders.ButtonViewHolder;
import com.qiubo.qiubo.ui.viewmodels.ItemVM;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Lawrence Cermeño on 08/03/18.
 */

public class SimpleButtonDelegate extends ViewPagerDelegate<ItemVM> {

    public static final int DELEGATE_TYPE = 256;

    @Override
    public int getDelegateType() {
        return DELEGATE_TYPE;
    }

    @Override
    public Object instantiateItem(List<ItemVM> items, ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_simple_buttons, container, false);
        container.addView(itemView);
        ItemVM itemVM = items.get(position);
        onCreateViewHolder(itemView, position, itemVM);
        return itemView;
    }

    @Override
    void onBindViewHolder(ItemVM item, Object holder) {
        ButtonViewHolder viewHolder = (ButtonViewHolder) holder;
        viewHolder.setValues(item);
    }

    @Override
    Object buildViewHolder(View itemView) {
        return new ButtonViewHolder(itemView);
    }
}