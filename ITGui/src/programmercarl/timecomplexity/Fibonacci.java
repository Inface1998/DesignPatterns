package programmercarl.timecomplexity;

import org.junit.Test;

/**
 * @Auther: zhaoss
 * @Date: 2022/1/13 - 01 - 13 - 21:19
 */
public class Fibonacci {
    @Test
    public void test1(){
        long startTime=System.currentTimeMillis();
        System.out.println(fibonacci(40));
        long endTime=System.currentTimeMillis();
        System.out.println("排序耗时   " +(endTime-startTime));
    }
    public static int  fibonacci(int i){
        if(i <= 0){
            return 0;
        }
        if(i == 1){
            return 1;
        }
        return fibonacci(i-1) + fibonacci(i-2);
    }
    public static int fibonacci2(int first,int second, int n){
        if(n <= 0){
            return 0;
        }
        if (n < 3){
            return 1;
        }else if (n == 3) {
            return first + second;
        }else {
            return fibonacci2(second,first+second,n-1);
        }
    }
}
