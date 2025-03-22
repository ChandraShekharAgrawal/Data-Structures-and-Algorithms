// Problem Statement - Leetcode 1930 - https://leetcode.com/problems/unique-length-3-palindromic-subsequences

// My Solution

// Current Solution

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] firstOccur = new int[26];
        int[] lastOccur = new int[26];
        int[] totalCount = new int[26];
        for(int i=0; i<26; i++){
            firstOccur[i] = -1;
            lastOccur[i] = -1;
        }
        for(int i=0; i<n; i++){
            int ch = s.charAt(i) - 'a';
            if(firstOccur[ch] == -1){
                firstOccur[ch] = i;
                totalCount[ch] = 1;
            } else {
                totalCount[ch]++;
                }
            lastOccur[ch] = i;
        }
        int palindromeCount = 0;
        for(int i=0; i<n; i++){
            int ch = s.charAt(i) - 'a';
            if(firstOccur[ch] != i){
                continue;
            } else {
                int[] temp = new int[26];
                for(int j=i+1; j<lastOccur[ch]; j++){
                    int currChar = s.charAt(j) - 'a';
                    if(temp[currChar] == 0){
                        palindromeCount++;
                        temp[currChar]++;
                    }
                }
            }
        }
        return palindromeCount;
    }
}

// Prev Solution

// class Solution {
//     public int countPalindromicSubsequence(String s) {
//         int[] lastOccur = new int[26];
//         int n = s.length();
//         for(int i=0; i<n; i++){
//             char ch = s.charAt(i);
//             lastOccur[ch-'a'] = i;
//         }
//         int[] vis = new int[26];
//         HashSet<String> palindrome = new HashSet<>();
//         for(int i=0; i<n; i++){
//             char curr = s.charAt(i);
//             int lastIndex = lastOccur[curr-'a'];            
//             if(vis[curr-'a'] == 0 && lastIndex - i > 1){
//                 StringBuilder sb = new StringBuilder();
//                 sb.append(curr);
//                 sb.append(curr);
//                 sb.append(curr);                
//                 for(int j=i+1; j<lastIndex; j++){
//                     sb.setCharAt(1, s.charAt(j));                    
//                     if(palindrome.contains(sb.toString()) == false){
//                         palindrome.add(sb.toString());
//                         //vis[s.charAt(j) - 'a'] = 1;
//                     }
//                 }
//             }
//             vis[curr-'a'] = 1;
//         }
//         return palindrome.size();
//     }
// }
