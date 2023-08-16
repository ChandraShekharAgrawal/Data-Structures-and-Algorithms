// problem statement - leetcode 239 - https://leetcode.com/problems/sliding-window-maximum/description

// my solution

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2-o1;
        });
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for(int i=0; i<k; i++){
            pq.add(nums[i]);
            if(numberMap.containsKey(nums[i]) == false){
                numberMap.put(nums[i],1);
            }
            else{
                numberMap.put(nums[i], numberMap.get(nums[i]) + 1);
            }
        }
        int[] ans = new int[n-k+1];
        ans[0] = pq.peek();
        for(int i=k; i<n; i++){
            if(nums[i-k] == pq.peek()){
                pq.remove();                
            }            
            numberMap.put(nums[i-k], numberMap.get(nums[i-k]) -1);
            while(pq.size()>0 && numberMap.get(pq.peek()) == 0){
                pq.remove();
            }
            pq.add(nums[i]);
            if(numberMap.containsKey(nums[i]) == false){
                numberMap.put(nums[i], 1);
            }
            else{
                numberMap.put(nums[i], numberMap.get(nums[i]) + 1);
            }            
            ans[i-k+1] = pq.peek();
        }
        return ans;
    }
}

// we can solve it using deque as well
