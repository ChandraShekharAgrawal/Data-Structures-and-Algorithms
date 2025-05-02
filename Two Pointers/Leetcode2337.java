// Problem Statement - Leetcode 2337 - https://leetcode.com/problems/move-pieces-to-obtain-a-string

// My Solution

class Solution {
    public boolean canChange(String start, String target) {
        int length = start.length();
        int startIndex = 0;
        int targetIndex = 0;
        while(startIndex < length || targetIndex < length){
            // find char in start
            while(startIndex < length && start.charAt(startIndex) == '_'){
               startIndex++;
            }
            // find char in target
            while(targetIndex < length && target.charAt(targetIndex) == '_'){
                targetIndex++;
            }
            if(startIndex == length || targetIndex == length){
                return startIndex == length && targetIndex == length;
            }
            if(start.charAt(startIndex) != target.charAt(targetIndex) || (start.charAt(startIndex) == 'L' && startIndex < targetIndex) || (start.charAt(startIndex) == 'R' && startIndex > targetIndex)){
                return false;
            }
            startIndex++;
            targetIndex++;
        }
        return true;
    }
}
