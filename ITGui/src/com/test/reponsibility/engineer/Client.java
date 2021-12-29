package com.test.reponsibility.engineer;

import org.junit.Test;


/**
 * @author : zhanghj
 */
public class Client{

    @Test
    public void test(){
        ProjectManager manager = new ProjectManager();
        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);
        //依次尝试解决bug
        manager.assignBug(easy);
        manager.assignBug(middle);
        manager.assignBug(hard);
    }

}
