package com.leetcode.note.easy;

/**
 * Created by huzhengying on 2019/3/20.
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     示例 1:
         输入: 123
         输出: 321
     示例 2:
         输入: -123
         输出: -321
     示例 3:
         假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [?231,  231 ? 1]。
         请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseNum {
    public static void main(String[] args) {
        System.out.println(reverse1(100));
        System.out.println(reverse2(100000));
        System.out.println(reverse3(10000000));
    }

    public static int reverse1(int x){
        long num = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            num = num * 10 + pop;
        }
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)num;
    }

    public static int reverse2(int x){
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(x));
        String num = stringBuffer.reverse().toString();
        if (x < 0) {
            num = "-" + num.replace("-","");
        }
        Long result = Long.valueOf(num);
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return Integer.valueOf(result.toString());
    }

    public static int reverse3(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
