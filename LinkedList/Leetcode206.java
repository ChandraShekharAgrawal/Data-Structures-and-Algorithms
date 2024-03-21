// Problem Statement - Leetcode 206 - https://leetcode.com/problems/reverse-linked-list

// My Solution

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        ListNode reversedList = null;
        while(temp != null){
            ListNode store = temp;
            temp = temp.next;
            store.next = reversedList;
            reversedList = store;
        }
        return reversedList;
    }
}
