// Problem Statement - Leetcode 124 - https://leetcode.com/problems/binary-tree-maximum-path-sum/

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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        findMaxPathSum(root, ans);
        return ans[0];
    }

    private int findMaxPathSum(TreeNode root, int[] ans){
        if(root==null){
            return 0;
        }
        int leftSum = Math.max(0,findMaxPathSum(root.left, ans));
        int rightSum = Math.max(0,findMaxPathSum(root.right, ans));
        ans[0] = Math.max(leftSum + rightSum + root.val, ans[0]);
        return root.val + Math.max(leftSum, rightSum);
    }
}
