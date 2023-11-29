// Problem Statement - Leetcode 1980 - https://leetcode.com/problems/find-unique-binary-string

// My Solution

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> s = new HashSet<>();
        for(int i=0; i<n; i++){
            s.add(nums[i]);
        }
        for(int i=0; i<(1<<n); i++){
            String binary = findBinary(i, n);
            if(s.contains(binary) == false){
                return binary;
            }
        }
        return "";
    }

    String findBinary(int num, int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if((num&(1<<i))> 0){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }
        int i=0;
        int j = n-1;
        while(i<j){
            char a = sb.charAt(i);
            char b = sb.charAt(j);
            sb.setCharAt(i, b);
            sb.setCharAt(j, a);
            i++;
            j--;
        }
        return sb.toString();
    }
}
