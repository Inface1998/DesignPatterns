package programmercarl.timecomplexity;

import org.junit.Test;

/**
 * 题目：求x的n次方
 *
 * @Auther: zhaoss
 * @Date: 2022/1/12 - 01 - 12 - 23:43
 */
public class Recursion {
    @Test
    public void test01() {
        System.out.println(function3(2, 3));
    }

    public static int function1(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }

    public static int function2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return function2(x, n - 1) * x;
    }

    public static int function3(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return function3(x, n / 2) * function3(x, n / 2) * x;
        }
        return function3(x, n / 2) * function3(x, n / 2);
    }

    public static int function4(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int t = function4(x, n / 2);
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }
}
