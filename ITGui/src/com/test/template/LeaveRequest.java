package com.test.template;

/**
 * @author : zhanghj
 */
abstract class LeaveRequest {
    void request(){
        System.out.println("myself:"+name());
        System.out.println("Because of "+reason()+" ask for leave about "+duration()+" days");
    }
    abstract String name();
    abstract String reason();
    abstract String duration();
}
