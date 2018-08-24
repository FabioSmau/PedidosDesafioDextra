package com.desafio.dextra.sandwichlist.recyclerview;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.listeners.OnItemClickListener;
import com.desafio.dextra.databinding.ItemSandwichListBinding;

import java.util.ArrayList;
import java.util.List;

public class SandwichesRecyclerAdapter extends RecyclerView.Adapter<SandwichViewHolder> {

    private OnItemClickListener<SandwichDescription> onItemClickListener;
    private List<SandwichDescription> sandwiches = new ArrayList<>();

    public SandwichesRecyclerAdapter(OnItemClickListener<SandwichDescription> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addSandwiches(List<SandwichDescription> sandwiches){
        this.sandwiches.addAll(sandwiches);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SandwichViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemSandwichListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_sandwich_list,
                viewGroup,
                false
        );

        return new SandwichViewHolder(binding, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SandwichViewHolder sandwichViewHolder, int i) {
        sandwichViewHolder.bind(sandwiches.get(i));
    }

    @Override
    public int getItemCount() {
        return sandwiches.size();
    }
}
