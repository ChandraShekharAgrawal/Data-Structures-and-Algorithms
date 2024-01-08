// Problem Statement - https://leetcode.com/problems/range-sum-of-bst/

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = findSum(root, low, high);
        return ans;
    }

    int findSum(TreeNode root, int low, int high){
        if(root == null){
            return 0;
        }
        int leftSum = findSum(root.left, low, high);
        int rightSum = findSum(root.right, low, high);
        int rootSum = 0;
        if(root.val >= low && root.val <= high){
            rootSum = root.val;
        }
        return leftSum + rightSum + rootSum;
    }
}
