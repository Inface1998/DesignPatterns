package com.msb.builder.house;

/**
 * @author : zhanghj
 */
public class HighBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("High basic");
    }

    @Override
    public void buildWall() {
        System.out.println("High wall");
    }

    @Override
    public void roofed() {
        System.out.println("High roof");
    }
}
