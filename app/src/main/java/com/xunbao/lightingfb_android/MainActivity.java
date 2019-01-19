package com.xunbao.lightingfb_android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.xunbao.lightingfb_android.entity.TabEntity;
import com.xunbao.lightingfb_android.fragment.GoodFragment;
import com.xunbao.lightingfb_android.fragment.MyFragment;
import com.xunbao.lightingfb_android.fragment.PlaceFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.content_fl)
    FrameLayout contentFl;
    @BindView(R.id.tablayout_ct)
    CommonTabLayout tablayoutCt;

    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    private String[] mTitles = {"装备","球场","我的"};
    private int[] mIconUnselectIds = {
            R.drawable.ic_good_unselected, R.drawable.ic_place_unselected,
            R.drawable.ic_my_unselected};
    private int[] mIconSelectIds = {
            R.drawable.ic_good_selected, R.drawable.ic_place_selected,
            R.drawable.ic_my_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();

    }

    private void initViews() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        fragments.add(GoodFragment.getInstance("装备"));
        fragments.add(PlaceFragment.getInstance("场地"));
        fragments.add(MyFragment.getInstance("我的"));
        tablayoutCt.setTabData(mTabEntities, this, R.id.content_fl, fragments);

    }
}
