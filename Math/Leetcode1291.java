// Problem Statement - Leetcode 1291 - https://leetcode.com/problems/sequential-digits

// My Solution

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> sequenceArray = new ArrayList<>();
        if(low > 123456789){
            return new ArrayList<>();
        }
        int digitLow = 0;
        int temp = low;
        while(temp > 0){
            temp = temp/10;
            digitLow++;
        }
        int digitHigh = 0;
        temp = high;
        while(temp > 0){
            temp = temp/10;
            digitHigh++;
        }
        int[] startNum = {0, 0, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789};
        int[] increment = {0, 0, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111};
        int[] maxNum = {0, 0, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999};
       
        
        int start = startNum[digitLow];
        while(start < low ){
            start += increment[digitLow];
            if(start%10 == 9){
                break;
            }
        }
        int startDigit = digitLow;
        // temp = start;
        // while(temp > 0){
        //     temp = temp/10;
        //     startDigit++;
        // }
        // if(startDigit != digitLow){
        //     start = startNum[digitLow+1];
        // }
        if(start < low){
            start = startNum[digitLow+1];
            startDigit = digitLow+1;
        }
        for(int i = startDigit; i<= digitHigh && i<=9; i++){
            if(i!= startDigit){
                start = startNum[i];
            }
            while(start < maxNum[i] && start <= high && (start%10 != 0)){
                sequenceArray.add(start);
                start += increment[i];
            }                
        }
        return sequenceArray;
    }
}
