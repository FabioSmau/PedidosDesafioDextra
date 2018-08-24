package com.desafio.dextra.menu;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.ActivityUtils;
import com.desafio.dextra.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    private MenuViewModel viewModel;
    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        viewModel = ViewModelProviders.of(this).get(MenuViewModel.class);

        setupFragmentSelected();
        setupBottomBar();
    }

    private void setupBottomBar() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(menuItem -> viewModel.onItemSelected(menuItem));
    }

    private void setupFragmentSelected() {
        viewModel.getFragmentLiveData().observe(this, fragment -> {
            if (fragment == null)
                return;

            ActivityUtils.replaceFragmentInActivity(getSupportFragmentManager(), fragment, R.id.frameContainer);
        });
    }


}
