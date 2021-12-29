package com.test.reponsibility.engineer;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class Client3 {
    @Test
    public void test() throws Exception {
        Programmer newbie = new Programmer("菜鸟");
        Programmer normal = new Programmer("普通");
        Programmer good = new Programmer("优秀");
        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);
        //链式责任传递
        if(!handleBug(newbie, easy)){
            if(!handleBug(normal,easy)){
                if(!handleBug(good,easy)){
                    throw new Exception("Kill the fake good programmer!");
                }
            }
        }
        if (!handleBug(newbie, middle)) {
            if (!handleBug(normal, middle)) {
                if (!handleBug(good, middle)) {
                    throw new Exception("Kill the fake good programmer!");
                }
            }
        }

        if (!handleBug(newbie, hard)) {
            if (!handleBug(normal, hard)) {
                if (!handleBug(good, hard)) {
                    throw new Exception("Kill the fake good programmer!");
                }
            }
        }

    }

    public boolean handleBug(Programmer programmer, Bug bug) {
        if (programmer.type.equals("菜鸟") && bug.value > 0 && bug.value <= 20) {
            programmer.solve(bug);
            return true;
        } else if (programmer.type.equals("普通") && bug.value > 20 && bug.value <= 50) {
            programmer.solve(bug);
            return true;
        } else if (programmer.type.equals("优秀") && bug.value > 50 && bug.value <= 100) {
            programmer.solve(bug);
            return true;
        }
        return false;
    }
}
