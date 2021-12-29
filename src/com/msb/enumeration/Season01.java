package com.msb.enumeration;

/**
 * @author : zhanghj
 */
public enum Season01 {
    //提供枚举类的有限的  确定的对象：--->enum枚举类要求对象（常量）必须放在最开始位置
    //多个对象之间用逗号进行连接，最后一个对象后面用;结束
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;


}

class TestSeason01{
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        //toString  -->获取对象的名字
        Season01 summer = Season01.SUMMER;
        System.out.println(summer.toString());

        //values:返回枚举类对象数组
        Season01[] values = Season01.values();
        for(Season01 s : values){
            System.out.println(s/*toString*/);
        }
        System.out.println("------------------");
        //valueOf: 通过对象名获取枚举对象
        Season01 autumn1 = Season01.valueOf("AUTUMN");
        System.out.println(autumn1);
    }
}
