package com.desafio.dextra.ingredients.recyclerview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.desafio.dextra.BR;
import com.squareup.picasso.Picasso;

public class IngredientDescription extends BaseObservable {

    private int id;
    private String name;
    private String price;
    private String urlImage;
    private int amount;

    @Bindable
    public String getAmount() {
        return String.valueOf(amount);
    }

    public void setAmount(int amount) {
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

    @Bindable
    public String getImageUrl() {
        return urlImage;
    }

    public void setImageUrl(String urlImage) {
        this.urlImage = urlImage;
        notifyPropertyChanged(BR.urlImage);
    }
}
