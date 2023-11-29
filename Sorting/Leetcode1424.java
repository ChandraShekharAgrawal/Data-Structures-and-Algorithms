// Problem Statement - Leetcode 1424 - https://leetcode.com/problems/diagonal-traverse-ii

// My Solution

class Solution {
    class Node{
        int diagSum;
        int row;
        int val;
        Node(int x, int y, int z){
            diagSum = x;
            row = y;
            val = z;
        }
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<nums.get(i).size(); j++){
                arr.add(new Node(i+j, i, nums.get(i).get(j)));
            }
        }
        Collections.sort(arr, (o1, o2) ->{
            if(o1.diagSum < o2.diagSum){
                return -1;
            }
            else if(o1.diagSum > o2.diagSum){
                return 1;
            }
            else{
                if(o1.row > o2.row){
                    return -1;
                }
                return 1;
            }
        });
        int[] ans = new int[arr.size()];
        for(int i=0; i< arr.size(); i++){
            ans[i] = arr.get(i).val;
        }
        return ans;
    }
}
