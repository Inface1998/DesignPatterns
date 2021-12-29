package com.test.reponsibility.engineer;

/**
 * @author : zhanghj
 */
public class ProjectManager {
    Programmer newbie = new Programmer("菜鸟");
    Programmer normal = new Programmer("普通");
    Programmer good = new Programmer("优秀");
    public void assignBug(Bug bug){
        if(bug.value > 0 && bug.value <= 20){
            System.out.println("assign it to newbie");
            newbie.solve(bug);
        }else if(bug.value > 20&&bug.value <= 50){
            System.out.println("assign it to normal");
            normal.solve(bug);
        }else if (bug.value > 50 && bug.value <=100 ){
            System.out.println("assign it to master");
            good.solve(bug);
        }
    }
}
