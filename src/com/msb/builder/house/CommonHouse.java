package com.msb.builder.house;

/**
 * @author : zhanghj
 */
public class CommonHouse extends HouseBuilder{

    @Override
    public void buildBasic() {
        System.out.println("common basic");
    }

    @Override
    public void buildWall() {
        System.out.println("common wall");
    }

    @Override
    public void roofed() {
        System.out.println("common roofed");
    }
}
