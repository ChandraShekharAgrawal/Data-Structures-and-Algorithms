// problem statement - leetcode 1048 - https://leetcode.com/problems/longest-string-chain

// my solution

class Solution {
    public int longestStrChain(String[] words) {
        int totalWords = words.length;
        Arrays.sort(words, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<totalWords; i++){
            mp.put(words[i], 1);
            for(int j=0; j<words[i].length(); j++){
                String remain = createStr(words[i], j);
                if(mp.containsKey(remain) == true){
                    mp.put(words[i], Math.max(mp.get(words[i]), mp.get(remain) + 1));
                }
            }
        }
        int ans = 1;
        for(String s : mp.keySet()){
            ans = Math.max(ans, mp.get(s));
        }
        return ans;
    }

    String createStr(String s, int index){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<index; i++){
            sb.append(s.charAt(i));
        }
        for(int i= index+1; i<s.length(); i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
