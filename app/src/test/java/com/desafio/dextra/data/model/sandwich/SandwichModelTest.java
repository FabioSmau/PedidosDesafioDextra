package com.desafio.dextra.data.model.sandwich;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientModel;
import com.desafio.dextra.data.model.promotions.strategy.ChainOfPromotionsStrategy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class SandwichModelTest {

    private Sandwich sandwich;

    @Before
    public void initSandwichModelMock(){
        sandwich = new SandwichModel(1,
                "SandwichTeste",
                "https://goo.gl/Cjfxi9");
    }

    private Ingredient createIngredientMock(double price){
        return new IngredientModel(1, "Teste Ingredient", price, "https://goo.gl/Cjfxi9");
    }

    @Test
    public void emptyIngredientsReturnPriceZeroWithoutPromotion(){
        assertThat(0.0, equalTo(sandwich.getTotalPriceWithoutPromotion()));
    }

    @Test
    public void emptyIngredientsReturnPriceZeroPromotion(){
        assertThat(0.0, equalTo(sandwich.getTotalPriceWithPromotion(new ChainOfPromotionsStrategy(sandwich))));
    }

    @Test
    public void emptyIngredients(){
        assertEquals(0, sandwich.getIngredients().size());
    }

    @Test
    public void addIngredientAndVerify(){
        Ingredient ingredient = createIngredientMock(10);
        sandwich.addIngredient(ingredient);
        assertEquals(1, sandwich.getIngredients().size());
    }

    @Test
    public void setListIngredients(){
        Ingredient ingredient1 = createIngredientMock(10);
        Ingredient ingredient2 = createIngredientMock(10);
        Ingredient ingredient3 = createIngredientMock(10);
        Ingredient ingredient4 = createIngredientMock(10);
//        sandwich.addIngredients(ingredient);
        assertEquals(0, sandwich.getIngredients().size());
    }

}