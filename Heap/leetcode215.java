// problem - leetcode 215 https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int numSize = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            minHeap.add(nums[i]);
        }
        for(int i=k; i<numSize; i++){
            if(minHeap.size()<k){
                minHeap.add(nums[i]);
            }
            else{
                if(minHeap.peek() < nums[i]){
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}
