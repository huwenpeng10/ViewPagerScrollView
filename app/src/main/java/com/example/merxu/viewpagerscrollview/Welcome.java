package com.example.merxu.viewpagerscrollview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MerXu on 2017/5/22.
 */

public class Welcome extends AppCompatActivity {

    private ViewPager viewPager;
    List<Fragment> fragmet = new ArrayList<>();
    private FragmentPagerAdapter adapter;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        initData();
    }

    private void initData() {
        fragmet.add(MainActivity.newInstances());
        fragmet.add(MainActivity.newInstances());
        fragmet.add(MainActivity.newInstances());
        adapter = new FragmentPagerAdapter(this.getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragmet.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragmet.get(arg0);
            }
        };
        viewPager.setAdapter(adapter);
        initTabLine();
    }

    private void initTabLine() {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("精选");
        tabLayout.getTabAt(1).setText("发现");
        tabLayout.getTabAt(2).setText("我的");
    }
}
