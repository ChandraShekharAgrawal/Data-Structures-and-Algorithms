// Problem Statement - Leetcode 1662 - https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent

// My Solution

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1 = word1.length;
        int n2 = word2.length;
        int string1 = 0;
        int string2 = 0;
        int index1 = 0;
        int index2 = 0;
        while(string1 < n1 && string2 < n2){
            if(index1 >= word1[string1].length()){
                string1++;
                index1 = 0;
            }
            if(index2 >= word2[string2].length()){
                string2++;
                index2 = 0;
            }
            if((string1<n1) && (string2 < n2) && (word1[string1].charAt(index1) != word2[string2].charAt(index2))){
                return false;
            }
            index1++;
            index2++;
        }
        if((string1 != n1) || (string2 != n2)){
            return false;
        }
        return true;
    }
}
