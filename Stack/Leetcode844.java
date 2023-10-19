// Problem Statement - Leetcode 844 - https://leetcode.com/problems/backspace-string-compare

// My Solution

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> firstString = new Stack<>();
        Stack<Character> secondString = new Stack<>();
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '#' && firstString.size()!= 0){
                firstString.pop();
            }
            else if(s.charAt(i) != '#'){
                firstString.push(s.charAt(i));
            }
        }
        for(int i=0; i< t.length(); i++){
            if(t.charAt(i) == '#' && secondString.size()!= 0){
                secondString.pop();
            }
            else if(t.charAt(i) != '#'){
                secondString.push(t.charAt(i));
            }
        }
        if(firstString.size() != secondString.size()){
            return false;
        }
        while(firstString.size() !=0){
            char first = firstString.pop();
            char second = secondString.pop();
            if(first != second){
                return false;
            }
        }
        return true;
    }
}
