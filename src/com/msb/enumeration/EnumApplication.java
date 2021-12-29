package com.msb.enumeration;

/**
 * @author : zhanghj
 */
public class EnumApplication {
    //属性
    private int age;
    private String name;
    private Gender sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "EnumApplication{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}

class Test{
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        EnumApplication e = new EnumApplication();
        e.setAge(19);
        e.setName("lili");
        e.setSex(Gender.男);//在入口处对属性进行了限制
        System.out.println(e.getSex());

        //switch后面的括号中可以传入枚举类型

        switch (e.getSex()){
            case 女:
                System.out.println("是个女孩");
            case 男:
                System.out.println("是个boy");
        }

    }
}
enum Gender {
    男,
    女;
}