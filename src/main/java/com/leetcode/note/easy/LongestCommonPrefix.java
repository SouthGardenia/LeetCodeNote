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
        longestCommonPrefix(new String[]{});
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            char[] headStringChars = strs[0].toCharArray();
            int longestCommonlocation = 0;
            boolean flag = false;
            for (int j = 0; j < headStringChars.length; j++) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() <= j || strs[i].charAt(j) != headStringChars[j]){
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                longestCommonlocation++;
            }
            return strs[0].substring(0,longestCommonlocation);
        }
    }
}
