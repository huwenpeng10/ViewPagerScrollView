package com.example.merxu.viewpagerscrollview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends Fragment {

    private RecyclerView recyclerView;
    private ViewPager viewPager;
    ArrayList<Fragment> fragmet = new ArrayList<>();
    ArrayList<String> datas;
    FragmentPagerAdapter adapter;

    private  View view;

    public static Fragment newInstances() {
        return new MainActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.activity_main, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Data();
        initView();
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        initData();
    }

    private void initData() {
        fragmet.add(FirstFragment.newInstances());
        fragmet.add(SecondFragment.newInstances());
        fragmet.add(ThreadFragment.newInstances());
        adapter = new FragmentPagerAdapter(this.getFragmentManager()) {
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
        viewPager.setCurrentItem(0);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RvAdapter(getActivity(),datas));
    }
    public void Data(){
        datas = new ArrayList<>();
        for (int i=0;i<50 ;i++){
            datas.add("第"+ i+"条数据");
        }
    }

    private void initView() {
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
    }
}
