// Problem Statement - Leetcode 543 - https://leetcode.com/problems/diameter-of-binary-tree

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = {0};
        findHeight(root, ans);
        return ans[0];
    }

    int findHeight(TreeNode root, int[] ans){
        if(root == null)
            return 0;
        int leftHeight = findHeight(root.left, ans);
        int rightHeight = findHeight(root.right, ans);
        if(leftHeight + rightHeight > ans[0]){
            ans[0] = leftHeight + rightHeight;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
