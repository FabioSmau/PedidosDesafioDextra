package com.desafio.dextra.sandwichlist.apagar;

import com.desafio.dextra.remote.BaseApiResponse;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;

import java.util.List;

public class SandwichApiResponse extends BaseApiResponse<List<SandwichDto>> {

    public SandwichApiResponse(List<SandwichDto> body) {
        super(body);
    }

    public SandwichApiResponse(Throwable error) {
        super(error);
    }
}
