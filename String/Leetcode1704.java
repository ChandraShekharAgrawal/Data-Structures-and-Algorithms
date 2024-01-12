// Problem Statement - Leetcode 1704 - https://leetcode.com/problems/determine-if-string-halves-are-alike/

// My Solution

class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count1 = 0;
        int count2 = 0;
        HashSet<Character> vowels = new HashSet<>();
        addVowel(vowels);
        for(int i=0; i<(n>>1); i++){
            if(vowels.contains(s.charAt(i)) == true){
                count1++;
            }
        }
        for(int i= (n>>1); i< n; i++){
            if(vowels.contains(s.charAt(i)) == true){
                count2++;
            }
        }
        if(count1 == count2){
            return true;
        }
        return false;
    }

    void addVowel(HashSet<Character> vowels){
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }
}
