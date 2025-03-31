// Problem Statement - Leetcode 1249 - https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

// My Solution

class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int leftCount = 0;
        int rightCount = 0;
        for(int i=0; i< n; i++){
            char currChar = s.charAt(i);
            if(currChar >= 'a' && currChar <= 'z'){
                sb.append(currChar);
            } else if(currChar == '('){
                leftCount++;
                sb.append(currChar);
            } else {
                rightCount++;
                if(rightCount > leftCount){
                    rightCount--;
                    continue;
                } else {
                    sb.append(currChar);
                }
            }
        }
        if(leftCount > rightCount){
            StringBuilder temp = new StringBuilder();
            int index = sb.length() -1 ;
            while(leftCount > rightCount){
                if(sb.charAt(index) == '('){
                    leftCount--;
                } else {
                    temp.append(sb.charAt(index));
                }
                index--;
            }
            StringBuilder ans = new StringBuilder();
            for(int i=0; i<=index; i++){
                ans.append(sb.charAt(i));
            }
            for(int i= temp.length()-1; i>=0; i--){
                ans.append(temp.charAt(i));
            }
            return ans.toString();
        }
        return sb.toString();
    }
}
