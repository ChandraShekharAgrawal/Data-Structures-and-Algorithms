// https://leetcode.com/problems/split-array-largest-sum/

// My Solution(Java)



class Solution {
    public int splitArray(int[] arr, int m) {
        
        int sumarr = Sumofarray(arr);  // min m = 1
        int largestarr = Maxarr(arr);  // max m = length of arr

        int ans = Findanswer(arr, sumarr, largestarr, m);
        return ans;        
    }
    
    int Maxarr(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    int Sumofarray(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }
        return ans;
    }    
    
    
    int Findanswer(int[] arr, int end, int start, int m){
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int partition = 1;
            for (int num : arr) {
                if (sum + num > mid) {
                    sum = num;
                    partition++;
                } else {
                    sum += num;
                }
            }
            if (partition > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
