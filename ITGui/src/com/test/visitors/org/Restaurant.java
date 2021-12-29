package com.test.visitors.org;

/**
 * @author : zhanghj
 */
public class Restaurant {
    private String lobster = "lobster";
    private String watermelon = "watermelon";
    private String steak = "steak";
    private String banana = "banana";
    public void welcome(IVisitor visitor){
        visitor.chooseLobster(lobster);
        visitor.chooseWatermelon(watermelon);
        visitor.chooseSteak(steak);
        visitor.chooseBanana(banana);
    }
}
