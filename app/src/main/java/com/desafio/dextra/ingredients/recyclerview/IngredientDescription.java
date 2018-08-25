package com.desafio.dextra.ingredients.recyclerview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.desafio.dextra.BR;
import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.ingredients.IngredientStepperView;
import com.squareup.picasso.Picasso;

public class IngredientDescription extends BaseObservable {

    private int id;
    private String name;
    private String price;
    private String urlImage;
    private int amount;

    @Bindable
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (this.amount == amount) return;
        this.amount = amount;
        notifyPropertyChanged(BR.amount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .into(view);
    }

    @BindingAdapter("app:amount")
    public static void setAmountInView(IngredientStepperView view, int amount) {
        view.updateFieldValue(amount);
    }

    @Bindable
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        notifyPropertyChanged(BR.imageUrl);
    }

    public static IngredientDescription valueOf(Ingredient ingredient) {
        IngredientDescription ingredientDescription = new IngredientDescription();
        ingredientDescription.setAmount(ingredient.getAmount());
        ingredientDescription.setId(ingredient.getId());
        ingredientDescription.setName(ingredient.getName());
        ingredientDescription.setUrlImage(ingredient.getImageUrl());
        ingredientDescription.setPrice(ingredient.getPriceUnitFormatted());
        return ingredientDescription;
    }
}
