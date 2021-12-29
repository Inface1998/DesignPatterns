package com.test.visitors.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhanghj
 */
public class Restaurant {
    private List<Food> prepareFoods(){
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            foods.add(new Lobster());
            foods.add(new Watermelon());
            foods.add(new Steak());
            foods.add(new Banana());
        }
        return foods;
    }
    public void welcome(IVisitor visitor){
        List<Food> foods = prepareFoods();
        for (Food food : foods) {
            food.accept(visitor);
        }
    }
}
