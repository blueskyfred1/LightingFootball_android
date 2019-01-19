package com.xunbao.lightingfb_android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.xunbao.lightingfb_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 张凯 on 2017-10-12 16:36.
 * TODO:
 */

public class MyFragment extends Fragment {
    @BindView(R.id.topbar)
    QMUITopBar topbar;
    @BindView(R.id.card_title_tv)
    TextView cardTitleTv;
    Unbinder unbinder;
    private String mTitle;

    public static MyFragment getInstance(String title) {
        MyFragment sf = new MyFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, null);
        unbinder = ButterKnife.bind(this, v);
        cardTitleTv.setText(mTitle);
        topbar.setTitle(mTitle);
//        QMUIStatusBarHelper.translucent(getActivity());
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
