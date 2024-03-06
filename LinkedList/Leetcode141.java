// Problem Statement - Leetcode 141 - https://leetcode.com/problems/linked-list-cycle

// My Solution

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null){
            if(slowPtr.next != null){
                slowPtr = slowPtr.next;
            }
            if(fastPtr.next != null){
                fastPtr = fastPtr.next.next;
            }
            else{
                fastPtr = null;
            }
            if(slowPtr == fastPtr){
                return true;
            }
        }
        if(fastPtr == null)
            return false;
        return true;
    }
}
