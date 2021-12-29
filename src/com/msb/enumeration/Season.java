package com.msb.enumeration;

/**
 * @author : zhanghj
 */
public enum Season {
    //提供枚举类的有限的  确定的对象：--->enum枚举类要求对象（常量）必须放在最开始位置
    //多个对象之间用逗号进行连接，最后一个对象后面用;结束
    SPRING("春天","春暖花开"),
    SUMMER("夏天","烈日炎炎"),
    AUTUMN ("秋天","硕果累累"),
    WINTER("冬天","冰天雪地");
    //属性:
    private final String seasonName;
    private final String seasonDesc;
    private Season(String seasonDesc,String seasonName){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    // 额外因素
    public String getSeasonName(){
        return seasonName;
    }
    public String getSeasonDesc(){
        return seasonDesc;
    }

}

class TestSeason{
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        //用enum关键字创建的Season枚举类上面的父类是：java.lang.Enum,常用方法子类Season可以直接拿过来使用：
        Season summer = Season.SUMMER;
        System.out.println(summer);
    }
}
