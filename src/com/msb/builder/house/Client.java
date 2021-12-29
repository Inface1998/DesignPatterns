package com.msb.builder.house;

/**
 * @author : zhanghj
 */
public class Client {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        //1.普通房子
        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        //完成盖房子，返回产品
        House house = houseDirector.constructHouse();

        //2.盖高楼
        HighBuilding highBuilding = new HighBuilding();
        //重置建造者
        houseDirector.setHouseBuilder(highBuilding);
        //完成盖房子，返回产品
        houseDirector.constructHouse();
    }
}
