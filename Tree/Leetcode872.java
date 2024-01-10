// Problem Statement - Leetcode 872 - https://leetcode.com/problems/leaf-similar-trees/

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> firstTreeLeaves = new ArrayList<>();
        findLeaf(root1, firstTreeLeaves);
        ArrayList<Integer> secondTreeLeaves = new ArrayList<>();
        findLeaf(root2, secondTreeLeaves);
        if(firstTreeLeaves.size() != secondTreeLeaves.size()){
            return false;
        }
        for(int i=0; i<firstTreeLeaves.size(); i++){
            if(firstTreeLeaves.get(i) != secondTreeLeaves.get(i)){
                return false;
            }
        }
        return true;
    }

    void findLeaf(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        findLeaf(root.left, arr);
        if(root.left == null && root.right == null)
            arr.add(root.val);
        findLeaf(root.right, arr);
    }
}
