package com.desafio.dextra.orders;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.base.BaseServiceFragment;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.desafio.dextra.databinding.FragmentOrderBinding;
import com.desafio.dextra.sandwich.recyclerview.SandwichDescription;

public class OrderFragment extends BaseServiceFragment {

    private OrderViewModel viewModel;
    private FragmentOrderBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false);
        viewModel = ViewModelProviders.of(this).get(OrderViewModel.class);

        setupBaseBehavior(viewModel);
        setupSandwichData();

        if (getArguments() != null) {
            int idSandwich = getArguments().getInt(Sandwich.KEY_EXTRA);
            viewModel.start(idSandwich);
        }

        return binding.getRoot();
    }

    private void setupSandwichData() {
        viewModel.getSandwich().observe(this, sandwich -> {
            if (sandwich == null)
                return;

            binding.setSandwichDescription(SandwichDescription.valueOf(sandwich));
        });
    }


}
