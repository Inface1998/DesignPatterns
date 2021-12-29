package com.test.template;

/**
 * @author : zhanghj
 */
public class MyLeaveRequest extends LeaveRequest{
    @Override
    String name() {
        return "zhj";
    }

    @Override
    String reason() {
        return "participate in Leetcode competition";
    }

    @Override
    String duration() {
        return "5";
    }
}
