// Problem Statement - Leetcode 94 - https://leetcode.com/problems/binary-tree-inorder-traversal

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> elements = new ArrayList<>();
        findInorder(root, elements);
        return elements;
    }

    void findInorder(TreeNode root, List<Integer> elements){
        if(root != null && root.left != null){
            findInorder(root.left, elements);
        }
        if(root != null){
            elements.add(root.val);
        }
        if(root != null && root.right != null){
            findInorder(root.right, elements);
        }
    }
}
