package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.test.adapter.ViewPagerAdapter;
import com.example.test.mainpage.MainFragment;
import com.example.test.mainpage.NewsFragment;
import com.example.test.mainpage.ServiceFragment;
import com.example.test.mainpage.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Context mContext;
    ViewPager mMainViewPage;
    BottomNavigationView mMainNavigationBtn;
    private MenuItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mContext = this;
        initView();
        listenView();
    }
    private void initView() {
        mMainViewPage = (ViewPager) findViewById(R.id.main_view_page);
        mMainNavigationBtn = (BottomNavigationView) findViewById(R.id.main_navigation_btn);

        //创建选择监听
        mMainNavigationBtn.setOnNavigationItemSelectedListener(this);

        //创建集合存入Fragment,类需要实现BottomNavigationView.OnNavigationItemSelectedListener
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new ServiceFragment());
        fragments.add(new NewsFragment());
        fragments.add(new UserFragment());

        //创建ViewPagerAdapter将集合传进去
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        mMainViewPage.setAdapter(viewPagerAdapter);
        mMainViewPage.setOffscreenPageLimit(fragments.size());
    }
    public void listenView() {
        //创建监听对象
        mMainViewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //item 为全局变量 private MenuItem item;
                if (item != null) {
                    item.setChecked(false);
                } else {
                    mMainNavigationBtn.getMenu().getItem(0).setChecked(true);
                }
                item = mMainNavigationBtn.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();//这里的id为menu文件下的id，用于监听点击的是哪一个
        if (itemId == R.id.main_service_btn) {//切换fragment
            mMainViewPage.setCurrentItem(1);
            menuItem.setChecked(true);
        } else if (itemId == R.id.main_news_btn) {
            mMainViewPage.setCurrentItem(2);
            menuItem.setChecked(true);
        } else if (itemId == R.id.main_user_btn) {
            mMainViewPage.setCurrentItem(3);
            menuItem.setChecked(true);
        } else {
            mMainViewPage.setCurrentItem(0);
            menuItem.setChecked(true);
        }
        return false;
    }
}