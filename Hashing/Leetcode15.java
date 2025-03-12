// Problem Statement - Leetcode 15 - https://leetcode.com/problems/3sum/

// My Solution - Java

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i<n; i++){
            indexMap.put(nums[i], i);
        }
        List<List<Integer>> ansList = new ArrayList<>();
        int prev = -100001;
        for(int i=0; i<n-2; i++){
            if(nums[i] == prev){
                continue;
            }
            int prevJ = -100001;
            for(int j=i+1; j<n-1; j++){
                if(nums[j] == prevJ){
                    continue;
                }
                int requiredSum = 0 - (nums[i] + nums[j]);
                if(indexMap.containsKey(requiredSum) && indexMap.get(requiredSum) > j){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[indexMap.get(requiredSum)]);
                    ansList.add(tempList);
                }
                prevJ = nums[j];
            }
            prev = nums[i];
        }
        return ansList;
    }
}
