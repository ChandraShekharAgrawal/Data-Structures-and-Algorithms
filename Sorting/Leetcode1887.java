// Problem Statement - Leetcode 1887 - https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/

// My Solution

class Solution {
    class Node{
        int value;
        int count;
        Node(int x, int y){
            value = x;
            count = y;
        }
    }
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> numberCount = new HashMap<>();
        int largestNum = nums[0];
        int smallestNum = nums[0];
        for(int i=0; i<n; i++){
            largestNum = Math.max(largestNum, nums[i]);
            smallestNum = Math.min(smallestNum, nums[i]);
            if(numberCount.containsKey(nums[i]) == false){
                numberCount.put(nums[i], 1);
            }
            else{
                numberCount.put(nums[i], numberCount.get(nums[i]) + 1);
            }
        }
        ArrayList<Node> arr = new ArrayList<>();
        for(Integer i : numberCount.keySet()){
            arr.add(new Node(i, numberCount.get(i)));
        }
        Collections.sort(arr, (o1, o2) ->{
            if(o1.value - o2.value > 0){
                return -1;
            }
            return 1;
        });
        int multiplier = numberCount.size() -1;
        int steps = 0;
        for(int i=0; i<arr.size(); i++){
            steps += (multiplier * arr.get(i).count);
            multiplier--;
        }
        return steps;
    }
}
