// Problem Statement - Leetcode 2610 - https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions

// My Solution

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> distinctRow = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i=0; i<n; i++){
            if(countMap.containsKey(nums[i]) == false){
                countMap.put(nums[i], 1);
            }
            else{
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }
        }
        for(Integer i: countMap.keySet()){
            while(countMap.get(i) > distinctRow.size()){
                distinctRow.add(new ArrayList<>());
            }
            for(int j=0; j< countMap.get(i); j++){
                distinctRow.get(j).add(i);
            }
        }
        return distinctRow;
    }
}
