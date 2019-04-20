package com.leetcode.note.easy;

/**
 * Created by huzhengying on 2019/4/20.
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(5);

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        ListNode curNode = listNode;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    /**
     * 从两个链表第一个Node开始较大小，小的链表Node放入新的链表中
     * 然后将小的链表移动至下一个元素，继续递归比较，直到两个链表中有一个链表为null
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode resultNode =  new ListNode(0);
        ListNode curNode = resultNode;
        while (true) {
            if (list1 == null) {
                curNode.next = list2;
                break;
            } else if (list2 == null) {
                curNode.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                curNode.next = list1;
                curNode = curNode.next;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                curNode = curNode.next;
                list2 = list2.next;
            }
        }
        return resultNode.next;

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}