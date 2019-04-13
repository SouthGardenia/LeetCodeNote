package com.leetcode.note.easy;

/**
 * Created by huzhengying on 2019/3/20.
 *
 * ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
     ʾ�� 1:
         ����: 123
         ���: 321
     ʾ�� 2:
         ����: -123
         ���: -321
     ʾ�� 3:
         �������ǵĻ���ֻ�ܴ洢���� 32 λ���з���������������ֵ��ΧΪ [?231,  231 ? 1]��
         �����������裬�����ת�����������ô�ͷ��� 0��
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
