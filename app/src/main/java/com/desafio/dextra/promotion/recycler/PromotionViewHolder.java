package com.desafio.dextra.promotion.recycler;

import android.support.v7.widget.RecyclerView;

import com.desafio.dextra.databinding.ItemPromotionListBinding;

public class PromotionViewHolder extends RecyclerView.ViewHolder{

    private ItemPromotionListBinding binding;

    public PromotionViewHolder(ItemPromotionListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(PromotionDescriptor descriptor){
        binding.setPromotionDescription(descriptor);
    }
}
