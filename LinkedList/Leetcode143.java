// Problem Statement - Leetcode 143 - https://leetcode.com/problems/reorder-list/

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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null){
            fast = fast.next;
            if(fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        ListNode slowNext = slow.next;
        slow.next = null;
        slow = slowNext;

        ListNode headReverse = null;
        while(slow != null){
            slowNext = slow.next;
            slow.next = headReverse;
            headReverse = slow;
            slow = slowNext;
        }

        ListNode temp = head;

        while(headReverse != null){
            ListNode nextNode = temp.next;
            temp.next = headReverse;
            ListNode nextReverse = headReverse.next;
            headReverse.next = nextNode;
            headReverse = nextReverse;
            temp = nextNode;
        }
    }
}
