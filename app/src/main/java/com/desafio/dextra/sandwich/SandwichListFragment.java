package com.desafio.dextra.sandwich;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.ActivityUtils;
import com.desafio.dextra.commom.base.BaseServiceFragment;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.desafio.dextra.databinding.FragmentSandwichListBinding;
import com.desafio.dextra.sandwich.recyclerview.SandwichDescription;
import com.desafio.dextra.sandwich.recyclerview.SandwichesRecyclerAdapter;
import com.desafio.dextra.orders.OrderFragment;

import java.util.List;

public class SandwichListFragment extends BaseServiceFragment {

    private static final String TAG = "SandwichListFragment";

    private FragmentSandwichListBinding binding;
    private SandwichesRecyclerAdapter sandwichesAdapter;
    private SandwichViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sandwich_list, container, false);
        viewModel = ViewModelProviders.of(this).get(SandwichViewModel.class);

        setupBaseBehavior(viewModel);
        setupRecyclerView();
        setupSandwiches();

        viewModel.start();

        return binding.getRoot();
    }

    private void setupSandwiches() {
        viewModel.listSandwiches().observe(this, (sandwiches -> {
            if (sandwiches == null)
                return;

            addItensRecyclerView(sandwiches);
        }));
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.recyclerSandwichs;
        sandwichesAdapter = new SandwichesRecyclerAdapter(clicked -> startOrderFragment(clicked.getId()));
        recyclerView.setAdapter(sandwichesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void startOrderFragment(int idSandwich) {
        if (getFragmentManager() != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(Sandwich.KEY_EXTRA, idSandwich);
            OrderFragment fragment = new OrderFragment();
            fragment.setArguments(bundle);

            ActivityUtils.replaceFragmentInActivity(getFragmentManager(), fragment, R.id.frameContainer);
        }
    }

    private void addItensRecyclerView(List<SandwichDescription> sandwichDescriptions) {
        sandwichesAdapter.addSandwiches(sandwichDescriptions);
    }
}
