// Problem Statement - Leetcode 68 https://leetcode.com/problems/text-justification/description/

// my solution

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
       List<String> ans = new ArrayList<>();
        int totalWords = words.length;
        int i = 0;
        while(i < totalWords){
            List<StringBuilder> temp = new ArrayList<>();
            //List<Integer> spaces = new ArrayList<>();
            int wordsCount = 0;
            int start = 1;
            int betweenCount = 0;
            while(i< totalWords && wordsCount <= maxWidth){
                if(start ==1){
                    if(wordsCount + words[i].length() > maxWidth ){
                        break;
                    }
                    wordsCount += words[i].length();
                    start = 0;
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[i]);
                    temp.add(sb);
                    i++;
                }
                else if(start ==0){
                    if(wordsCount + words[i].length() + 1 > maxWidth){
                        break;
                    }
                    wordsCount += words[i].length() + 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[i]);
                    betweenCount++;
                    temp.add(sb);
                    i++;
                }
            }
            if(i!=totalWords){
                if(betweenCount == 0){
                    StringBuilder curr = temp.get(0);
                    int spaces = maxWidth - wordsCount;
                    for(int s=0; s<spaces; s++){
                        curr.append(' ');
                    }
                    ans.add(curr.toString());
                }
                else{
                    int totalSpaces = maxWidth - wordsCount + betweenCount;
                    int equalSpaces = totalSpaces/betweenCount;
                    int remSpaces = totalSpaces % betweenCount;
                    StringBuilder curr = new StringBuilder();
                    for(int k =0; k< temp.size(); k++){
                        curr.append(temp.get(k));
                        // add spaces
                        if(k != temp.size()-1) {
                            for (int s = 0; s < equalSpaces; s++) {
                                curr.append(' ');
                            }
                        }
                        if(remSpaces != 0){
                            curr.append(' ');
                            remSpaces--;
                        }
                    }
                    ans.add(curr.toString());
                }
            }
            else{
                StringBuilder curr = new StringBuilder();
                for(int k=0; k<temp.size(); k++){
                    curr.append(temp.get(k));
                    if(curr.length() < maxWidth){
                        curr.append(' ');
                    }
                }
                // add remaining spaces
                int spaces = maxWidth - curr.length();
                for(int s=0; s< spaces; s++){
                    curr.append(' ');
                }
                ans.add(curr.toString());
            }
        }
        return ans;
    }
}
