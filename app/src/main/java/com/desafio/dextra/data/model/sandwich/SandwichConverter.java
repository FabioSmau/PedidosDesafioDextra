package com.desafio.dextra.data.model.sandwich;

import java.util.ArrayList;
import java.util.List;

public class SandwichConverter {

    public List<Sandwich> convert(List<SandwichDto> sandwichesDtos) {
        List<Sandwich> sandwiches = new ArrayList<>();
        for (SandwichDto dto : sandwichesDtos) {
            sandwiches.add(SandwichModel.valueOf(dto));
        }
        return sandwiches;
    }

}
