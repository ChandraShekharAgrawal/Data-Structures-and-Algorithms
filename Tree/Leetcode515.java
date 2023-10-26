// Problem Statement - Leetocode 515 - https://leetcode.com/problems/find-largest-value-in-each-tree-row

// My Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestRow = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null){
            q.add(root);
        }
        while(q.size()!= 0){
            int largeValue = Integer.MIN_VALUE;
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                TreeNode temp = q.remove();
                largeValue = Math.max(largeValue, temp.val);
                if(temp.left!= null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            largestRow.add(largeValue);
        }
        return largestRow;
    }
}
