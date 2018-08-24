package com.desafio.dextra.promotion.recycler;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.desafio.dextra.R;
import com.desafio.dextra.databinding.ItemPromotionListBinding;

import java.util.ArrayList;
import java.util.List;

public class PromotionRecyclerAdapter extends RecyclerView.Adapter<PromotionViewHolder> {

    private List<PromotionDescriptor> promotions = new ArrayList<>();

    public void addPromotions(List<PromotionDescriptor> promotions) {
        this.promotions.addAll(promotions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemPromotionListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_promotion_list,
                viewGroup,
                false
        );

        return new PromotionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder promotionViewHolder, int i) {
        promotionViewHolder.bind(promotions.get(i));
    }

    @Override
    public int getItemCount() {
        return promotions.size();
    }
}
