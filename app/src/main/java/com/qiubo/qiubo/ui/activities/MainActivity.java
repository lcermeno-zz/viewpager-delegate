package com.qiubo.qiubo.ui.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qiubo.qiubo.R;
import com.qiubo.qiubo.ui.adapters.viewpagers.QiuboPagerAdapter;
import com.qiubo.qiubo.ui.adapters.viewpagers.SimpleButtonDelegate;
import com.qiubo.qiubo.ui.adapters.viewpagers.SimpleImageDelegate;
import com.qiubo.qiubo.ui.adapters.viewpagers.SimpleTextViewDelegate;
import com.qiubo.qiubo.ui.viewmodels.ContentVM;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vw_pager_main)
    ViewPager mViewPager;
    private QiuboPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupModule();
    }

    private void setupModule() {
        ButterKnife.bind(this);
        mAdapter = new QiuboPagerAdapter();
        mViewPager.setAdapter(mAdapter);
        loadItems();
    }

    private void loadItems() {
        List<ContentVM> contentVMS = new ArrayList<>();

        ContentVM vm1 = new ContentVM();
        vm1.setViewType(SimpleImageDelegate.DELEGATE_TYPE);

        ContentVM vm2 = new ContentVM();
        vm2.setViewType(SimpleButtonDelegate.DELEGATE_TYPE);

        ContentVM vm3 = new ContentVM();
        vm3.setViewType(SimpleTextViewDelegate.DELEGATE_TYPE);

        ContentVM vm4 = new ContentVM();
        vm4.setViewType(SimpleImageDelegate.DELEGATE_TYPE);

        ContentVM vm5 = new ContentVM();
        vm5.setViewType(SimpleButtonDelegate.DELEGATE_TYPE);

        ContentVM vm6 = new ContentVM();
        vm6.setViewType(SimpleTextViewDelegate.DELEGATE_TYPE);

        contentVMS.add(vm1);
        contentVMS.add(vm2);
        contentVMS.add(vm3);
        contentVMS.add(vm4);
        contentVMS.add(vm5);
        contentVMS.add(vm6);

        mAdapter.setItems(contentVMS);
    }
}
