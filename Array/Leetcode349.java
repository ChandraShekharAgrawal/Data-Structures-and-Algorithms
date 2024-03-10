// Problem Statement - Leetcode 349 - https://leetcode.com/problems/intersection-of-two-arrays

// My Solution

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n2; i++){
            set.add(nums2[i]);
        }
        HashSet<Integer> intersectSet = new HashSet<>();
        for(int i=0; i<n1; i++){
            if(set.contains(nums1[i])){
                intersectSet.add(nums1[i]);
            }
        }
        int[] intersectionArray = new int[intersectSet.size()];
        int index = 0;
        for(Integer i: intersectSet){
            intersectionArray[index] = i;
            index++;
        }
        return intersectionArray;
    }
}
