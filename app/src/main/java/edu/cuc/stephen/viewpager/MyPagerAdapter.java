package edu.cuc.stephen.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    private List<String> titleList;

    public MyPagerAdapter(List<View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    //摄制页面标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    //返回页卡的数量
    @Override
    public int getCount() {
        return viewList.size();
    }

    //判断View是否来自于对象
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }

    //实例化页卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewList.get(position);
        container.addView(view);
        return view;
    }

    //销毁页卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
