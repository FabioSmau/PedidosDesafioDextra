package com.desafio.dextra.sandwichlist;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.base.BaseFragment;
import com.desafio.dextra.databinding.FragmentSandwichListBinding;
import com.desafio.dextra.sandwichlist.recyclerview.SandwichDescription;
import com.desafio.dextra.sandwichlist.recyclerview.SandwichesRecyclerAdapter;

import java.util.List;

public class SandwichListFragment extends BaseFragment {

    private static final String TAG = "SandwichListFragment";

    private FragmentSandwichListBinding binding;
    private SandwichesRecyclerAdapter sandwichesAdapter;
    private SandwichViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sandwich_list, container, false);

        viewModel = ViewModelProviders.of(this).get(SandwichViewModel.class);

        setupBaseFragment();
        setupRecyclerView();
        setupLoadingState();
        setupErrorState();
        setupSandwiches();

        viewModel.start();

        return binding.getRoot();
    }

    private void setupSandwiches() {
        viewModel.getSandwichesDescriptorLiveData().observe(this, (sandwiches -> {
            if (sandwiches == null)
                return;

            addItensRecyclerView(sandwiches);
        }));
    }

    private void setupErrorState() {
        viewModel.getErrorState().observe(this, (throwable -> {
            if (throwable == null) {
                return;
            }
            Log.e(TAG, throwable.getMessage());
            showDialog(throwable.getMessage());
        }));
    }

    private void setupLoadingState() {
        viewModel.getLoadingState().observe(this, loading -> {
            if (loading == null)
                return;

            if (loading) {
                showLoading();
            } else {
                hideLoading();
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.recyclerSandwichs;
        sandwichesAdapter = new SandwichesRecyclerAdapter(clicked -> {
            Log.i(TAG, "Abrir tela de detalhes do: " + clicked.getName());
        });
        recyclerView.setAdapter(sandwichesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void addItensRecyclerView(List<SandwichDescription> sandwichDescriptions) {
        sandwichesAdapter.addSandwiches(sandwichDescriptions);
    }
}
