package com.test.reponsibility.rookie;

import org.junit.Test;


/**
 * @author : zhanghj
 */
public class Client{

    @Test
    public void test(){
        Programmer newbie = new Programmer("菜鸟");
        Programmer normal = new Programmer("普通");
        Programmer good = new Programmer("优秀");
        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);
        //依次尝试解决bug
        handleBug(newbie,easy);
        handleBug(normal, easy);
        handleBug(good, easy);

        handleBug(newbie, middle);
        handleBug(normal, middle);
        handleBug(good, middle);

        handleBug(newbie, hard);
        handleBug(normal, hard);
        handleBug(good, hard);
    }


    public void handleBug(Programmer programmer,Bug bug ){
        if (programmer.type.equals("菜鸟")&&bug.value> 0&&bug.value<=20){
            programmer.solve(bug);
        }else if (programmer.type.equals("普通")&& bug.value>20 &&bug.value<=50){
            programmer.solve(bug);
        }else if (programmer.type.equals("优秀")&&bug.value>50&&bug.value<100){
            programmer.solve(bug);
        };

    }

}
