// Problem Statement - Leetcode 2034 - https://leetcode.com/problems/stock-price-fluctuation/

// My Solution - Java

class StockPrice {
    private int maxPriceTimeStamp;
    private int maxPrice;
    private int minPriceTimeStamp;
    private int minPrice;
    private final Map<Integer, Stock> priceMap;
    private final PriorityQueue<Stock> minQueue;
    private final PriorityQueue<Stock> maxQueue;
    private int latestTime;
    private int latestPrice;

    public StockPrice() {
        latestTime = 0;
        latestPrice = 0;
        priceMap = new HashMap<>();
        minQueue = new PriorityQueue<>((stock1, stock2) -> {
            if(stock1.price < stock2.price){
                return -1;
            } else if(stock1.price > stock2.price){
                return 1;
            } else {
                return stock2.timestamp - stock1.timestamp;
            }
        });
        maxQueue = new PriorityQueue<>((stock1, stock2) -> {
            if(stock1.price > stock2.price){
                return -1;
            } else if(stock1.price < stock2.price){
                return 1;
            } return stock2.timestamp - stock1.timestamp;

        });
    }

    class Stock {
        private int timestamp;
        private int price;

        public Stock(){

        }

        public Stock(int time, int price){
            this.timestamp = time;
            this.price = price;
        }
    }
    
    public void update(int timestamp, int price) {
        Stock stockToAdd = new Stock(timestamp, price);
        minQueue.add(stockToAdd);
        maxQueue.add(stockToAdd);
        priceMap.put(timestamp, stockToAdd);
        if(timestamp >= latestTime){
            latestTime = timestamp;
            latestPrice = price;
        }
    }
    
    public int current() {
        return latestPrice;
    }
    
    public int maximum() {
        while(maxQueue.size() > 0 && priceMap.containsKey(maxQueue.peek().timestamp) && (priceMap.get(maxQueue.peek().timestamp).price != maxQueue.peek().price)){
            maxQueue.remove();
        }
        return maxQueue.peek().price;
    }
    
    public int minimum() {
        while(minQueue.size() > 0 && priceMap.containsKey(minQueue.peek().timestamp) && (priceMap.get(minQueue.peek().timestamp).price != minQueue.peek().price)){
            minQueue.remove();
        }
        return minQueue.peek().price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
