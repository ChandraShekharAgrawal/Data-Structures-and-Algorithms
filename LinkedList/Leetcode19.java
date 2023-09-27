// problems statement - leetcode 19 - https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// my solution

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while(temp!= null){
            count++;
            temp = temp.next;
        }
        int position = count - n + 1;
        if(position == 1){
            return head.next;
        }
        count = 1;
        temp = head;
        while(count < position-1){
            count++;
            temp = temp.next;
        }
        if(temp.next.next == null){
            temp.next = null;
        }
        else{
            temp.next = temp.next.next;
        }
        return head;
    }
}
