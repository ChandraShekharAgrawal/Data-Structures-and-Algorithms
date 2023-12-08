// Problem Statement - Leetcode 606 - https://leetcode.com/problems/construct-string-from-binary-tree

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
    private String ans;
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        findBuild(root, str);
        ans = str.toString();
        return ans;
    }

    void findBuild(TreeNode root, StringBuilder str){
        if(root == null){
            return;
        }
        str.append(root.val);
        if(root.right != null && root.left != null){
            str.append('(');
            findBuild(root.left, str);
            str.append(')');
            str.append('(');
            findBuild(root.right, str);
            str.append(')');
        }
        else if(root.left == null && root.right == null){
            return;
        }
        else if(root.left == null && root.right != null){
            str.append('(');
            str.append(')');
            str.append('(');
            findBuild(root.right, str);
            str.append(')');
        }
        else{
            str.append('(');
            findBuild(root.left, str);
            str.append(')');
        }
        return;
    }
}
