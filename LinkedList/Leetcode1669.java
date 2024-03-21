// Problem Statement - Leetcode 1669 - https://leetcode.com/problems/merge-in-between-linked-lists/

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        int count = 1;
        while(count < a){
            temp = temp.next;
            count++;
        }
        ListNode prev = temp;
        temp = temp.next;
        while(count <= b){
            temp = temp.next;
            count++;
        }
        ListNode list2Last = list2;
        while(list2Last.next != null){
            list2Last = list2Last.next;
        }
        prev.next = list2;
        list2Last.next = temp;
        return list1;
    }
}
