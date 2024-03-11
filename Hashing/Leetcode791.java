// Problem Statement - Leetcode 791 - https://leetcode.com/problems/custom-sort-string

// My Solution

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(mapS.containsKey(c) == false){
                mapS.put(c, 1);
            }
            else{
                mapS.put(c, mapS.get(c) + 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<order.length(); i++){
            int count = 0;
            char ch = order.charAt(i);
            if(mapS.containsKey(ch) == true){
                count = mapS.get(ch);
            }
            for(int j=0; j<count; j++){
                stringBuilder.append(ch);
            }
            mapS.put(ch, 0);
        }
        for(int i=0; i< s.length(); i++){
            if(mapS.get(s.charAt(i))!= 0){
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
