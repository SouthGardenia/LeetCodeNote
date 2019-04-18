package com.leetcode.note.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by huzhengying on 2019/4/17.
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。

     示例 1:
         输入: "()"
         输出: true
     示例 2:
         输入: "()[]{}"
         输出: true
     示例 3:
         输入: "(]"
         输出: false
 */
public class EffectiveParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));;
    }

    /**
     * 利用stack栈实现，遍历目标字符串，将左括号推入栈中，遇到右括号时取出栈顶元素并检查
     * 最后如果栈为空则表示符合要求
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != hashMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 硬编码方法，写了几版，无疾而终
     * @param str
     * @return
     */
    public static boolean isValid1(String str) {
        String[] parenthesesChars = str.split("");
        if (parenthesesChars.length == 0 || parenthesesChars.length % 2 != 0) {
            return false;
        } else {
            return true;
        }
    }


}
