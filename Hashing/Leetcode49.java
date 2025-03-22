// Problem Statement - Leetcode 49 - https://leetcode.com/problems/group-anagrams/

// My Solution - here, I used a complicated approach for creating key for map; but it could've been simplified with 
// just sorting the word ans use that as key

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int strsLength = strs.length;
        Map<String, List<Integer>> strMap = new HashMap<>();
        for(int i=0; i< strsLength; i++){
            String currStr = strs[i];
            StringBuilder temp = new StringBuilder();
            for(int j=0; j<26; j++){
                temp.append('0');
            }
            int[] charCount = new int[26];
            for(int j=0, currStrLen = currStr.length(); j<currStrLen; j++){
                int ch = currStr.charAt(j) - 'a';
                temp.setCharAt(ch, '1');
                charCount[ch]++;
            }
            for(int j=0; j<26; j++){
                if(charCount[j] != 0){
                    temp.append('-');
                    temp.append(charCount[j]);
                }
            }
            String key = temp.toString();
            if(strMap.containsKey(key)){
                strMap.get(key).add(i);
            } else {
                List<Integer> tempIndex = new ArrayList<>();
                tempIndex.add(i);
                strMap.put(key, tempIndex);
            }
        }
        List<List<String>> anagramGroup = new ArrayList<>();
        for(String key: strMap.keySet()){
            List<Integer> indexList = strMap.get(key);
            List<String> tempList = new ArrayList<>();
            for(int j=0, indexLen = indexList.size(); j< indexLen; j++){
                tempList.add(strs[indexList.get(j)]);
            }
            anagramGroup.add(tempList);
        }
        return anagramGroup;
    }
}
