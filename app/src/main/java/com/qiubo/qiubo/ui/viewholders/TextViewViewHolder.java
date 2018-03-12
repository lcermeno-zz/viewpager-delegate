package com.qiubo.qiubo.ui.viewholders;

import android.view.View;
import android.widget.TextView;

import com.qiubo.qiubo.R;
import com.qiubo.qiubo.ui.viewmodels.ItemVM;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lawrence Cermeño on 12/03/18.
 */

public class TextViewViewHolder {

    @BindView(R.id.txt_vw_item)
    TextView mTextView;

    public TextViewViewHolder(View itemView) {
        ButterKnife.bind(this, itemView);
    }

    public void setValues(ItemVM item) {
        mTextView.setText(item.getResourceId());
    }
}
