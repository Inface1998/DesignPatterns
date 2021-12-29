package com.msb.builder.house;

/**
 * @author : zhanghj
 */
//指挥者去指定制作流程，返回产品
public class HouseDirector {
    HouseBuilder houseBuilder = null;
    //通过构造器传入houseBuilder
    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    //通过setter传入houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    //如何建造房子交给指挥者
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
