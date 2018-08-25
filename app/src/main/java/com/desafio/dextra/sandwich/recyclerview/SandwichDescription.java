package com.desafio.dextra.sandwich.recyclerview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.desafio.dextra.BR;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SandwichDescription extends BaseObservable {

    private int id;
    private String name;
    private String price;
    private String ingredients;
    private String urlImage;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    @Bindable
    public String getIngredients() {
        return ingredients;
    }

    @Bindable
    public String getUrlImage() {
        return urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = TextUtils.join(", ", ingredients);
        notifyPropertyChanged(BR.ingredients);
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        notifyPropertyChanged(BR.urlImage);
    }

    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .into(view);
    }

    public static SandwichDescription valueOf(Sandwich sandwich) {
        SandwichDescription descriptor = new SandwichDescription();
        descriptor.setName(sandwich.getName());
        descriptor.setUrlImage(sandwich.getImageUrl());
        descriptor.setId(sandwich.getId());
        descriptor.setIngredients(sandwich.getIngredientsName());
        descriptor.setPrice(sandwich.getPriceWithPromotionFormatted());
        return descriptor;
    }

}
