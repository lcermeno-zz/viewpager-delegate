package com.qiubo.qiubo.ui.viewholders;

import android.view.View;
import android.widget.Button;

import com.qiubo.qiubo.R;
import com.qiubo.qiubo.ui.viewmodels.ItemVM;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lawrence Cermeño on 12/03/18.
 */

public class ButtonViewHolder {

    @BindView(R.id.btn_1)
    Button mBtn1;
    @BindView(R.id.btn_2)
    Button mBtn2;
    @BindView(R.id.btn_3)
    Button mBtn3;
    @BindView(R.id.btn_4)
    Button mBtn4;
    @BindView(R.id.btn_5)
    Button mBtn5;

    public ButtonViewHolder(View itemView) {
        ButterKnife.bind(this, itemView);
    }

    public void setValues(ItemVM item) {
        mBtn1.setText(item.getResourceId());
        mBtn2.setText(item.getResourceId());
        mBtn3.setText(item.getResourceId());
        mBtn4.setText(item.getResourceId());
        mBtn5.setText(item.getResourceId());
    }
}
