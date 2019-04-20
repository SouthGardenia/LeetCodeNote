package com.leetcode.note.easy;

/**
 * Created by huzhengying on 2019/4/20.
 *
 * 实现 strStr() 函数,给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回-1。
    示例 1:
        输入: haystack = "hello", needle = "ll"
        输出: 2
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr1("hanlde", "hanlde"));
    }

    /**
     * 这道题这样实现的很尴尬、、
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 手写一波，
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        String str = null;
        for (int i = 0; i < haystackLen; i++) {
            if (haystackLen - i >= needleLen) {
                str = haystack.substring(i, i + needleLen);
                if (needle.equals(str)) {
                    return i;
                }
            } else {
                return -1;
            }
        }
        return -1;
    }
}
