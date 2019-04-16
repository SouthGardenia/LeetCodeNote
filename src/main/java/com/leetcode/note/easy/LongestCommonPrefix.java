package com.leetcode.note.easy;

/**
 * Created by huzhengying on 2019/4/15.
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀，如果不存在公共前缀，返回空字符串 ""。
     示例 1:
         输入: ["flower","flow","flight"]
         输出: "fl"
     示例 2:
         输入: ["dog","racecar","car"]
         输出: ""
     解释: 输入不存在公共前缀。
     说明: 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower","flower1231","flight"}));
    }

    /**
     * 水平查找
     * @param strs
     * @return
     */
    private static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            //取字符串数组中第一个字符串，拆分成字符数组（也可以取其它位置的字符串）
            char[] headStringChars = strs[0].toCharArray();
            //遍历字符数组
            for (int j = 0; j < headStringChars.length; j++) {
                //每通过遍历一次，意味着公共前缀长度+1
                for (int i = 1; i < strs.length; i++) {
                    //当前字符串是否够长 || 当前字符串的第j个字符与字符数组的j个字符是否相等
                    if (strs[i].length() <= j || strs[i].charAt(j) != headStringChars[j]){
                        //返回符合公共前缀
                        return strs[0].substring(0, j);
                    }
                }
            }
            return strs[0];
        }
    }

    /**
     * 官方：二分法查找
     * @param strs
     * @return
     */
    private static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            int minLength = Integer.MAX_VALUE;
            for (String str : strs) {
                minLength = Math.min(minLength, str.length());
            }
            int low = 1;
            int high = minLength;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (isCommonPrefix(strs, middle)) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
            return strs[0].substring(0, (low + high) / 2);
        }
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str)) {
                return false;
            }
        }
        return true;
    }
}
