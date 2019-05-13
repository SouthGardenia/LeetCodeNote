package com.leetcode.note.easy;

/**
 * Created by huzhengying on 2019/4/29.
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
    示例 1:
     输入: [1,2,3]
     输出: [1,2,4]
     解释: 输入数组表示数字 123。

    示例 2:
     输入: [4,3,2,1]
     输出: [4,3,2,2]
     解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        //从尾部开始遍历，不断进位
        for(int i = digits.length - 1; i >= 0; i--){
            //如果第i位小于9，则直接将其加1返回
            if (digits[i] < 9) {
                digits[i] = digits[i]+1;
                return digits;
            }
            //如果第i位等于9，则将其设置为0
            digits[i] = 0;
        }
        //走到这步说明所有位都是9，则直接初始化一个digits.length+1长度的数组，第一位设置为1
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3,4};
        plusOne(digits);
    }

}
