package edu.cuc.stephen.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private List<View> viewList;
    private ViewPager viewPager;
    private PagerTabStrip tabStrip;
    private List<String> titleList;
    private List<android.support.v4.app.Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewList = new ArrayList<>();
        View view1 = View.inflate(this, R.layout.layoutview1, null);
        View view2 = View.inflate(this, R.layout.layoutview2, null);
        View view3 = View.inflate(this, R.layout.layoutview3, null);
        View view4 = View.inflate(this, R.layout.layoutview4, null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        fragmentList = new ArrayList<>();
        fragmentList.add(new MyFragment1());
        fragmentList.add(new MyFragment2());
        fragmentList.add(new MyFragment3());
        fragmentList.add(new MyFragment4());

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        titleList = new ArrayList<>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");
        tabStrip = (PagerTabStrip) findViewById(R.id.tabStrip);
        tabStrip.setBackgroundColor(Color.YELLOW);
        tabStrip.setTextColor(Color.BLUE);
        tabStrip.setDrawFullUnderline(false);
        tabStrip.setTabIndicatorColor(Color.GREEN);

        //创建适配器
        //MyPagerAdapter adapter = new MyPagerAdapter(viewList, titleList);
        MyFragmentPagerAdapter fragmentPagerAdapter =
                new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titleList);
        //加载适配器
        //viewPager.setAdapter(adapter);
        viewPager.setAdapter(fragmentPagerAdapter);
    }


}
