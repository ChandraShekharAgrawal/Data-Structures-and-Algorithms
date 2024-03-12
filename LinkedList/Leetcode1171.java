// Problem Statement - Leetcode 1171 - https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list

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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode temp = head;
        int sum = 0;
        while(temp != null){
            sum += temp.val;
            ListNode curr = temp;
            if(sum == 0){
                head = temp.next;
                nodeSet = new HashSet<>();
            }
            else if(map.containsKey(sum) == false){
                map.put(sum, curr);
                nodeSet.add(curr);
            }
            else{
                ListNode exist = map.get(sum);
                if(nodeSet.contains(exist)){
                    ListNode existTemp = exist.next;
                    while(existTemp != curr){
                        nodeSet.remove(existTemp);
                        existTemp = existTemp.next;
                    }
                    exist.next = temp.next;
                }
                else{
                    map.put(sum, curr);
                    nodeSet.add(curr);
                }               
            }
            temp = temp.next;
        }
        return head;
    }
}
