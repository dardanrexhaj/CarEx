package com.noexis.carex.initial.pager;

import androidx.viewpager2.widget.ViewPager2;

public class PageChangeListener {

    private PageChangeListenerInstance callback;

    public PageChangeListener setCallback(PageChangeListenerInstance callback){
        this.callback = callback;
        return this;
    }

    public PageChangeListener registerViewPager(ViewPager2 viewPager2){
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                callback.onPageChanged(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        return this;
    }
}
