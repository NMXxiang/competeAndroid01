package com.example.test.mainpage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.adapter.ImageAdapter;
import com.example.test.bean.DataBean;
import com.example.test.tool.getImage;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private Banner banner;
    private View view;
    public MainFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (view == null){
            view = inflater.inflate(R.layout.fragment_main, container, false);
        }
        banner = view.findViewById(R.id.home_banner);
        loadBanner();
        return view;
    }

    private void loadBanner() {
        List<String> bannerUrl = new ArrayList<>();
        bannerUrl.add("http://www.news.cn/photo/2023-07/27/1129770065_16904091418571n.JPG");
        bannerUrl.add("http://www.news.cn/photo/2023-07/26/1129768771_16903566137781n.JPG");
        bannerUrl.add("http://www.news.cn/photo/2023-07/26/1129768201_16903319099711n.JPG");
        banner.setAdapter(new ImageAdapter(DataBean.getTestData3()));// 设置数据
        banner.setIndicator(new CircleIndicator(getActivity()));     // 设置上下文
        banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);

    }
}