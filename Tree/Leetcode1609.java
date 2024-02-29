// Problem Statement - Leetcode 1609 - https://leetcode.com/problems/even-odd-tree/

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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        boolean ans = true;
        while(q.size() != 0){
            int qsize = q.size();
            if(level == 0){
                int prev = -1;
                for(int i=0; i<qsize; i++){
                    TreeNode temp = q.remove();
                    if((temp.val&1) == 0){
                        ans = false;
                        break;
                    }
                    if(i==0){
                        prev = temp.val;
                    }
                    else{
                        if(temp.val <= prev){
                            ans = false;
                            break;
                        }
                        prev = temp.val;
                    }
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                }
                level = 1;
            }
            else{
                int prev = -1;
                for(int i=0; i<qsize; i++){
                    TreeNode temp = q.remove();
                    if((temp.val&1) != 0){
                        ans = false;
                        break;
                    }
                    if(i==0){
                        prev = temp.val;
                    }
                    else{
                        if(temp.val >= prev){
                            ans = false;
                            break;
                        }
                        prev = temp.val;
                    }
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                }
                level = 0;
            }
        }
        return ans;
    }
}
