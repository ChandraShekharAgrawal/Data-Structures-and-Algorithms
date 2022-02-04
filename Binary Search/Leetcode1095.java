// https://leetcode.com/problems/find-in-mountain-array/

// My Solution (Java)

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;
        int ans = -1;
        
        
        int index = -1;
        while(start<end){
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                end = mid;
            }
            else{
                start = mid +1;
            }
        }
        
        index = start;
        
        //search in acc
        start = 0;
        end = index;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid) < target){
                start = mid + 1;
            }
            else if(mountainArr.get(mid) > target){
                end = mid - 1;
            }
            else{
                ans = mid;
                break;
            }
        }
        
        if(ans>=0){
            return ans;
        }
        else{
            start = index;
            end = mountainArr.length()-1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(mountainArr.get(mid) > target){
                    start = mid + 1;
                }
                else if(mountainArr.get(mid) < target){
                    end = mid - 1;
                }
                else{
                    ans = mid;
                    break;
                }
            }
            return ans;
        }
        
    }
}
