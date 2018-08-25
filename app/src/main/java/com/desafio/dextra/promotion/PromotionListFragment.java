package com.desafio.dextra.promotion;

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
import com.desafio.dextra.commom.base.BaseServiceFragment;
import com.desafio.dextra.databinding.FragmentPromotionsListBinding;
import com.desafio.dextra.promotion.recycler.PromotionDescriptor;
import com.desafio.dextra.promotion.recycler.PromotionRecyclerAdapter;

import java.util.List;

public class PromotionListFragment extends BaseServiceFragment {

    private static final String TAG = "PromotionListFragment";

    private FragmentPromotionsListBinding binding;
    private PromotionRecyclerAdapter adapter = new PromotionRecyclerAdapter();
    private PromotionViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_promotions_list, container, false);

        viewModel = ViewModelProviders.of(this).get(PromotionViewModel.class);

        setupBaseBehavior(viewModel);
        setupRecyclerView();
        setupPromotions();

        viewModel.start();

        return binding.getRoot();
    }

    private void setupPromotions() {
        viewModel.listPromotions().observe(this, (promotion -> {
            if (promotion == null)
                return;

            addItensRecyclerView(promotion);
        }));
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.recyclerPromotions;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void addItensRecyclerView(List<PromotionDescriptor> promotionDescriptors) {
        adapter.addPromotions(promotionDescriptors);
    }
}
