package programmercarl.timecomplexity;

import java.util.Scanner;

/**
 * @author : zhanghj
 */
public class TestTimes {
    //这是一个main方法,是程序的入口：
    public static void main(String[] args) {
        long n;
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("please input a number");
            long input = sc.nextLong();
            long startTime=System.currentTimeMillis();
            function2(input);
            long endTime=System.currentTimeMillis();
            System.out.println("排序耗时   " +(endTime-startTime));
        }
    }
    public static void function1(long n){
        long k = 0;
        for (long i = 0; i <n ; i++) {
            k++;
        }
    }
    public static void function2(long n){
        long k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                k++;
            }
        }
    }
    public static void function3(long n){
        long k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j = j * 2) {
                k++;
            }
        }
    }
}
