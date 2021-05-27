package com.noexis.carex.initial.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.noexis.carex.R;
import com.noexis.carex.databinding.FragmentInitialBinding;
import com.noexis.carex.initial.InitialActivity;
public class InitialFragment extends Fragment {

    private InitialActivity activity;
    private FragmentInitialBinding binding;
    private String title;
    private String description;
    private Integer position;

    public InitialFragment(InitialActivity activity, String title, String description,int position) {
        this.activity = activity;
        this.title = title;
        this.description = description;
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity),
                R.layout.fragment_initial, null, false);
        binding.titleTextView.setText(title);
        binding.descriptionTextView.setText(description);
        loadImageView();
        return binding.getRoot();
    }

    private void loadImageView(){
        switch (position){
            case 1:
                Glide.with(activity).load(R.drawable.car).into(binding.centerImageView);
                break;
            case 2:
                Glide.with(activity).load(R.drawable.second_car).into(binding.centerImageView);
                break;
            case 3:
                Glide.with(activity).load("https://media.giphy.com/media/UxuY43UbBUcu6kFTQG/giphy.gif").into(binding.centerImageView);
                break;
        }
    }
}
