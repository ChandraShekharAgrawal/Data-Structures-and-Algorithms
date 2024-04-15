// Problem Statement - Leetcode 3113 - https://leetcode.com/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum/

// My Solution

class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i]) == false){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i], temp);                
            }
            else{
                ArrayList<Integer> temp = map.get(nums[i]);
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
        
        int[] largestRight = new int[n];
        largestRight[n-1] = -1;
        
        Stack<Integer> stack = new Stack<>();
        stack.add(n-1);
        
        for(int i= n-2; i>=0; i--){
            while(stack.size() != 0 && nums[i] >= nums[stack.peek()] ){
                stack.pop();
            }
            largestRight[i] = stack.size() == 0? -1 : stack.peek();
            stack.add(i);
        }
        
        long ans = 0;
        for(int i=0; i<n; i++){
            ArrayList<Integer> temp = map.get(nums[i]);
            // int start = 0;
            int last = largestRight[i] == -1 ? n : largestRight[i];
            
            int startIndex = findIndex(temp, i, temp.size());
            int endIndex = findEnd(temp, last, temp.size());
            ans += (endIndex - startIndex + 1);
        }
        return ans;
    }

    public int findEnd(ArrayList<Integer> temp, int val, int n){
        int start = 0;
        int end = n-1;
        int index = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(temp.get(mid) < val){
                index = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return index;
    }
    
    public int findIndex(ArrayList<Integer> temp, int val, int n){
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid = (start+ end)/2;
            if(temp.get(mid) == val){
                return mid;
            }
            else if(temp.get(mid) < val){
                start = mid + 1;
            }
            else{
                end = mid -1 ;
            }
        }
        return -1;
    }
}
