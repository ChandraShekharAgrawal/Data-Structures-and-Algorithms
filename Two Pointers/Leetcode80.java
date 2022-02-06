// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

// My Solution (Java)

class Solution {
    public int removeDuplicates(int[] nums) {
        
        // prev element, index, count
        int PrevElement = nums[0];
        int count = 1;
        int index = 0;
        int ans = 1;
        for(int i=1; i< nums.length; i++){
            
           
            
            // if prev element = curr element
            if(nums[i]== PrevElement){
                count++;
                nums[i-index] = nums[i];
                
            }
            else{
                PrevElement = nums[i];
                if(count>=2)
                    index += count - 2;
                if(index>0){
                    nums[i-index] = nums[i];
                }
                count = 1;
            }
            
             if(count<=2){
                ans++;
            }
        }
        return ans;
        
    }
}
