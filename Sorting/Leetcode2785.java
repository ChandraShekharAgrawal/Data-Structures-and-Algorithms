// Problem Statement - Leetcode 2785 - https://leetcode.com/problems/sort-vowels-in-a-string/

// My Solution

class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        ArrayList<Character> vowel = new ArrayList<>();
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            if(curr == 'A' || curr == 'E' || curr == 'I' || curr == 'O' || curr == 'U' || curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u'){
                vowel.add(curr);
            }
        }
        Collections.sort(vowel);
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            if(curr == 'A' || curr == 'E' || curr == 'I' || curr == 'O' || curr == 'U' || curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u'){
                ans.append(vowel.get(j));
                j++;
            }
            else{
                ans.append(curr);
            }
        }
        return ans.toString();
    }
}
