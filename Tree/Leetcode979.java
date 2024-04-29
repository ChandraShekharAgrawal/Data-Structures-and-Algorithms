// Problem Statement - Leetcode 979 - https://leetcode.com/problems/distribute-coins-in-binary-tree

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
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        findExcessCoin(root);
        return moves;
    }

    int findExcessCoin(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftExcessCoin = findExcessCoin(root.left);
        int rightExcessCoin = findExcessCoin(root.right);

        moves += (Math.abs(leftExcessCoin) + Math.abs(rightExcessCoin));
        return root.val + leftExcessCoin + rightExcessCoin - 1;
    }
}
