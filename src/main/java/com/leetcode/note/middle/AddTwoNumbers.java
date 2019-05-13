package com.leetcode.note.middle;

/**
 * Created by huzhengying on 2019/4/22.
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum = getReverseNumber(l1) + getReverseNumber(l2);
        ListNode listNode = new ListNode(0);
        ListNode currNode = listNode;
        String number = sum + "";
        number = new StringBuffer(number).reverse().toString();
        for (String c : number.split("")) {
            currNode.next = new ListNode(Integer.valueOf(c));
            currNode = currNode.next;
        }

        return listNode.next;
    }

    private long getReverseNumber(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        while (listNode != null) {
            stringBuilder.append(listNode.val);
            listNode = listNode.next;
        }
        return Long.valueOf(stringBuilder.toString());
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}