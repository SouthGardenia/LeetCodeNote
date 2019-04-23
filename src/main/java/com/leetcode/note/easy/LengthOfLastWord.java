package com.leetcode.note.easy;

/**
 * Created by huzhengying on 2019/4/23.
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
    说明：一个单词是指由字母组成，但不包含任何空格的字符串。
    示例:
        输入: "Hello World"
        输出: 5
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord1(" "));
    }

    /**
     * 根据空格切分字符串，获取字符串数组末尾字符串的长度
     * @param s
     * @return
     */
    public static int lengthOfLastWord1(String s) {
        String[] words = s.split(" ");
        int wordsLength = words.length;
        return wordsLength == 0 ? 0 : words[wordsLength - 1].length();
    }

    /**
     * 获取最后一个空格位置，截取字符串并返回其长度
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ") + 1).length();
    }

    /**
     * 总长度-启始到最后一个空格长度
     * @param s
     * @return
     */
    public static int lengthOfLastWord3(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

}
