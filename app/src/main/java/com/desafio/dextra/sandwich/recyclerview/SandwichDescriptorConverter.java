package com.desafio.dextra.sandwich.recyclerview;

import com.desafio.dextra.data.model.sandwich.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class SandwichDescriptorConverter {

    public List<SandwichDescription> convert(List<Sandwich> sandwiches){
        List<SandwichDescription> sandwichDescriptions = new ArrayList<>();

        for (Sandwich sandwich : sandwiches){
            sandwichDescriptions.add(SandwichDescription.valueOf(sandwich));
        }

        return sandwichDescriptions;
    }

}
