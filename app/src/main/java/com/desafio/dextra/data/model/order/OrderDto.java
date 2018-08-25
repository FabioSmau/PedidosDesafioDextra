package com.desafio.dextra.data.model.order;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderDto implements Serializable {

    private int id;

    @SerializedName("id_sandwich")
    private int inSandwich;

    private List<Integer> extras = new ArrayList<>();

    private long date;


    public int getId() {
        return id;
    }

    public int getInSandwich() {
        return inSandwich;
    }

    public List<Integer> getExtras() {
        return extras;
    }

    public long getDate() {
        return date;
    }
}
