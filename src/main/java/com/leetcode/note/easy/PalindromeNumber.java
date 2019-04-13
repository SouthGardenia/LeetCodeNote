package com.leetcode.note.easy;

/**
 * Created by huzhengying on 2019/4/9.
 *
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
     ʾ�� 1:
         ����: 121
         ���: true
     ʾ�� 2:
         ����: -121
         ���: false

     ����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome1(-121));
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        long palindromeNumber = 0;
        long num = (long)x;
        while (x != 0) {
            palindromeNumber = palindromeNumber * 10 + x % 10;
            x /= 10;
        }
        if (palindromeNumber == num){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int palindromeNumber = 0;
        while (x > palindromeNumber) {
            palindromeNumber = palindromeNumber * 10 + x % 10;
            x /= 10;
        }
        if (palindromeNumber == x || palindromeNumber / 10 == x) {
            return true;
        } else {
            return false;
        }
    }
}
