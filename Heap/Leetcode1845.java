// Problem Statement - Leetcode 1845 - https://leetcode.com/problems/seat-reservation-manager

// My Solution

class SeatManager {
    // private int[] arr;
    private PriorityQueue<Integer> pq;
    public SeatManager(int n) {
        // arr = new int[n];
        pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            pq.add(i);
        }
    }
    
    public int reserve() {
        int unreservedSeat = pq.remove();
        return unreservedSeat;
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
