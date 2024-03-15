// Problem Statement - Leetcode 238 - https://leetcode.com/problems/product-of-array-except-self

// My Solution

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product = 1;
        int countZero = 0;
        for(int i=0; i<n; i++){
            product = product * nums[i];
            if(nums[i] == 0){
                countZero++;
            }
        }
        int[] productAns = new int[n];
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                productAns[i] = product/nums[i];
            }
            else{
                if(countZero == 1){
                    productAns[i] = 1;
                    for(int j=0; j<n; j++){
                        if(j == i){
                            continue;
                        }
                        productAns[i] = productAns[i] * nums[j];
                    }
                }
                else{
                    productAns[i] = 0;
                }
            }
        }
        return productAns;
    }
}
