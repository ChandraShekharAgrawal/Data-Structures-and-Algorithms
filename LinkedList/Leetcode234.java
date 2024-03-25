// Problem Statement - Leetcode 234 - https://leetcode.com/problems/palindrome-linked-list

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null){
            fast = fast.next;
            if(fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        ListNode reverseHead = null;
        slow = slow.next;
        while(slow != null){
            ListNode temp = slow;
            slow = slow.next;
            temp.next = reverseHead;
            reverseHead = temp;
        }
        
        ListNode temp = head;

        while(temp != null && reverseHead != null){
            if(temp.val != reverseHead.val){
                return false;
            }
            temp = temp.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }
}
