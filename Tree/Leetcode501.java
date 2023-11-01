// Problem Statement - Leetcode501 - https://leetcode.com/problems/find-mode-in-binary-search-tree

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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        fillMap(mp, root);
        int highestFreq = 0;
        for(Integer i: mp.keySet()){
            highestFreq = Math.max(highestFreq, mp.get(i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer i: mp.keySet()){
            if(mp.get(i) == highestFreq){
                ans.add(i);
            }
        }
        int[] findArr = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            findArr[i] = ans.get(i);
        }
        return findArr;
    }

    void fillMap(HashMap<Integer, Integer>mp, TreeNode root){
        if(root == null){
            return;
        }
        if(mp.containsKey(root.val) == false){
            mp.put(root.val, 1);
        }
        else{
            mp.put(root.val, mp.get(root.val)+1);
        }
        fillMap(mp, root.left);
        fillMap(mp, root.right);
    }
}
