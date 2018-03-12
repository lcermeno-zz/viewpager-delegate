package com.qiubo.qiubo.ui.viewholders;

import android.view.View;
import android.widget.ImageView;

import com.qiubo.qiubo.R;
import com.qiubo.qiubo.ui.viewmodels.ItemVM;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lawrence Cermeño on 12/03/18.
 */

public class ImageViewHolder {

    @BindView(R.id.img_vw_item)
    ImageView mImageView;

    public ImageViewHolder(View itemView) {
        ButterKnife.bind(this, itemView);
    }

    public void setValues(ItemVM itemVM) {
        mImageView.setImageResource(itemVM.getResourceId());
    }
}
