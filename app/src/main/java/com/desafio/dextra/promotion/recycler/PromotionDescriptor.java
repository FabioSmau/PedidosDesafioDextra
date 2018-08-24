package com.desafio.dextra.promotion.recycler;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.desafio.dextra.BR;
import com.desafio.dextra.data.model.promotions.Promotion;

public class PromotionDescriptor extends BaseObservable {

    private int id;
    private String name;
    private String description;

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    public static PromotionDescriptor valueOf(Promotion promotion) {
        PromotionDescriptor descriptor = new PromotionDescriptor();
        descriptor.setId(promotion.getId());
        descriptor.setName(promotion.getName());
        descriptor.setDescription(promotion.getDescription());
        return descriptor;
    }
}
