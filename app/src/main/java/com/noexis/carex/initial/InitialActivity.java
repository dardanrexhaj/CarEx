package com.noexis.carex.initial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.noexis.carex.MainActivity;
import com.noexis.carex.R;
import com.noexis.carex.databinding.ActivityInitialBinding;
import com.noexis.carex.initial.pager.InitialFragment;
import com.noexis.carex.initial.pager.PageChangeListener;
import com.noexis.carex.initial.pager.PageChangeListenerInstance;

import java.util.ArrayList;
import java.util.List;

public class InitialActivity extends AppCompatActivity implements PageChangeListenerInstance {

    private ActivityInitialBinding binding;

    private ScreenSlidePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_initial);
        setupViewPager();
    }

    private void setupViewPager() {
        adapter = new ScreenSlidePagerAdapter(this.getSupportFragmentManager(), this.getLifecycle());
        adapter.addFragment(new InitialFragment(this, "Add your car", "Add multiple cars and check what you spend in them",1));
        adapter.addFragment(new InitialFragment(this, "Add expenses spend on the car", "Add multiple cars and check what you spend in them \n Add multiple cars and check what you spend in them",2));
        adapter.addFragment(new InitialFragment(this, "Check what you spend and when", "Add multiple cars and check what you spend in them \n Add multiple cars and check what you spend in them Add multiple cars and check what you spend in them",3));
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                Log.d("position", position + " " + adapter.getItemCount());

            }
        }).attach();

        new PageChangeListener().registerViewPager(binding.viewPager).setCallback(this);
    }

    public void onStartClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onPageChanged(int position) {
        if (position == adapter.getItemCount() - 1) {
            binding.appCompatButton.setEnabled(true);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragmentList.size();
        }
    }
}