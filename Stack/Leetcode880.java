// Problem Statement - Leetcode 880 - https://leetcode.com/problems/decoded-string-at-index/description

// my solution

class Solution {
    class Node{
        char c;
        long index;
        Node(char x, long y){
            c = x;
            index = y;
        }
    }
    public String decodeAtIndex(String s, int k) {
        int len = s.length();
        long K = k;
        Stack<Node> st = new Stack<>();
        long currLen = 0;
        for(int i=0; i<len; i++){
            char temp = s.charAt(i);
            if(temp >= '2' && temp <= '9'){
                currLen *= (temp - '0');
            }
            else{
                currLen++;
                st.push(new Node(temp, currLen));
            }
            if(currLen > K){
                break;
            }
        }
        while(st.size() > 0){
            if( K%st.peek().index == 0){
                return "" + st.peek().c;
            }
            K = K%st.peek().index;
            st.pop();
        }
        return "";
    }
}
