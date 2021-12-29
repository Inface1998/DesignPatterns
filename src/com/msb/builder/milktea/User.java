package com.msb.builder.milktea;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class User {
    @Test
    public void buyTea(){
        MilkTea  milkTea = new MilkTea.Builder("原味").build();
        show(milkTea);

    }

    private void show(MilkTea milkTea){
        String pearl;
        if(milkTea.isPearl()) pearl = "加珍珠";
        else pearl ="不加珍珠";
        String ice;
        if (milkTea.isIce()){
            ice = "加冰";
        }else {
            ice = "不加冰";
        }
        System.out.print(milkTea.toString());
    }

}
