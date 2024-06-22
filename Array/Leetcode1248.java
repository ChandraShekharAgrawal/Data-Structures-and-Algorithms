// Problem Statement - Leetcode 1248 - https://leetcode.com/problems/count-number-of-nice-subarrays

// My Solution

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] oddCount = new int[n];
        if((nums[0]& 1) > 0){
            oddCount[0] = 1;
        }
        for(int i=1; i<n; i++){
            if((nums[i] & 1) > 0){
                oddCount[i] = oddCount[i-1] + 1;
            }
            else{
                oddCount[i] = oddCount[i-1];
            }
        }
        int oddArray = 0;
        int lookPrev = 0;
        int lookCurr = k;
        
        int prevAns = 0;
        int j = 0;
        for(int i=0; i<n; i++){
            boolean innerFlag = true;
            if(i!=0){
                lookCurr = k + oddCount[i-1];
            }
            if(lookCurr == lookPrev){
                oddArray += prevAns;
            }
            else{
                int len = 0;
                while(j<n){
                    if(oddCount[j] < lookCurr){
                        j++;
                    }
                    else if(oddCount[j] == lookCurr){
                        len++;
                        j++;
                    }
                    else{
                        innerFlag = false;
                        oddArray += len;
                        prevAns = len;
                        break;
                    }
                }
                if(innerFlag){
                    oddArray += len;
                    prevAns = len;
                }
            }
            lookPrev = lookCurr;
        }
        return oddArray;
    }
}
