// Problem Statement - Leetcode 1235 - https://leetcode.com/problems/maximum-profit-in-job-scheduling

// My Solution

class Solution {
    class Job{
        int start;
        int end;
        int money;
        Job(int x, int y, int z){
            start = x;
            end = y;
            money = z;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int totalJobs = startTime.length;
        Job[] jobs = new Job[totalJobs];
        int[] dp = new int[totalJobs];
        for(int i=0; i<totalJobs; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            dp[i] = -1;
        }
        Arrays.sort(jobs, (o1, o2)->{
            if(o1.start < o2.start){
                return -1;
            }
            else if(o1.start > o2.start){
                return 1;
            }
            else{
                return o1.end - o2.end;
            }
        });      
        return findProfit(jobs, totalJobs, 0, dp);
    }

    int findProfit(Job[] jobs, int n, int index, int[] dp){
        if(index >= n){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int nextIndex = findNextIndex(jobs[index].end, jobs, n, index);
        int takeCurrent = jobs[index].money + findProfit(jobs, n, nextIndex, dp);
        int excludeCurrent = findProfit(jobs, n, index+1, dp);
        return dp[index] = Math.max(takeCurrent, excludeCurrent);
    }

    int findNextIndex(int endVal, Job[] jobs, int n, int index){
        int startInt = index + 1;
        int endInt = n-1;
        int ans = n;
        while(startInt <= endInt){
            int mid = (startInt + endInt)/2;
            if(jobs[mid].start < endVal){
                startInt = mid + 1;
            }
            else{
                ans = mid;
                endInt = mid - 1;
            }
        }
        return ans;
    }
}
