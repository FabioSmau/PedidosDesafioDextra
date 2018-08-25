package com.desafio.dextra.sandwich.recyclerview;

import android.support.v7.widget.RecyclerView;
import com.desafio.dextra.commom.listeners.OnItemClickListener;
import com.desafio.dextra.databinding.ItemSandwichListBinding;

public class SandwichViewHolder extends RecyclerView.ViewHolder {

    private OnItemClickListener<SandwichDescription> itemClickListener;
    private ItemSandwichListBinding binding;

    SandwichViewHolder(ItemSandwichListBinding binding, OnItemClickListener<SandwichDescription> itemClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        this.itemClickListener = itemClickListener;
    }

    public void bind(SandwichDescription sandwiches){
        binding.setSandwichDescription(sandwiches);
        itemView.setOnClickListener(view -> itemClickListener.onClick(sandwiches));
    }
}
