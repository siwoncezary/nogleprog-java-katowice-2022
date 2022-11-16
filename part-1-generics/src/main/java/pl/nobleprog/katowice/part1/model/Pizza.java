package pl.nobleprog.katowice.part1.model;

import java.util.Arrays;

public class Pizza {
    private String[] ingredients;


    public Pizza(String... ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return String.format("Class Pizza {ingredients: %s}", Arrays.stream(ingredients).reduce((a, s) -> a +", "+ s).orElse("No ingredients"));
    }

    public String[] getIngredients(){
        return Arrays.copyOf(ingredients, ingredients.length);
    }

    public void setIngredients(String ...ingredients){
        this.ingredients = ingredients;
    }
}