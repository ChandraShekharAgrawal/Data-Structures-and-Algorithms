// Problem Statement - Leetcode 1930 - https://leetcode.com/problems/unique-length-3-palindromic-subsequences

// My Solution

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] lastOccur = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            lastOccur[ch-'a'] = i;
        }
        int[] vis = new int[26];
        HashSet<String> palindrome = new HashSet<>();
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            int lastIndex = lastOccur[curr-'a'];            
            if(vis[curr-'a'] == 0 && lastIndex - i > 1){
                StringBuilder sb = new StringBuilder();
                sb.append(curr);
                sb.append(curr);
                sb.append(curr);                
                for(int j=i+1; j<lastIndex; j++){
                    sb.setCharAt(1, s.charAt(j));                    
                    if(palindrome.contains(sb.toString()) == false){
                        palindrome.add(sb.toString());
                        //vis[s.charAt(j) - 'a'] = 1;
                    }
                }
            }
            vis[curr-'a'] = 1;
        }
        return palindrome.size();
    }
}
