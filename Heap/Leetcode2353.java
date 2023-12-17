// Problem Statement - Leetcode 2353 - https://leetcode.com/problems/design-a-food-rating-system/

// My Solution

class FoodRatings {
    private class FoodNode{
        String cuisine;
        int rating;
        FoodNode(String a, int b){
            cuisine = a;
            rating = b;
        }
    }
    private class CuisineNode{
        String food;
        int rating;
        CuisineNode(String a, int b){
            food = a;
            rating = b;
        }
    }
    private HashMap<String, FoodNode> foodInfo;
    private HashMap<String, PriorityQueue<CuisineNode>> cuisineInfo;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        foodInfo = new HashMap<>();
        cuisineInfo = new HashMap<>();
        for(int i=0; i<n; i++){
            foodInfo.put(foods[i], new FoodNode(cuisines[i], ratings[i]));
            if(cuisineInfo.containsKey(cuisines[i]) == false){
                cuisineInfo.put(cuisines[i], new PriorityQueue<>((o1, o2)->{
                    if(o1.rating > o2.rating){
                        return -1;
                    }
                    else if(o1.rating < o2.rating){
                        return 1;
                    }
                    else{
                        String first = o1.food;
                        String second = o2.food;
                        int len = Math.min(first.length(), second.length());
                        for(int j=0; j<len; j++){
                            if(first.charAt(j) < second.charAt(j)){
                                return -1;
                            }
                            else if(first.charAt(j) > second.charAt(j)){
                                return 1;
                            }
                        }
                        if(first.length() < second.length()){
                            return -1;
                        }
                        return 1;
                    }
                }));
            }
            cuisineInfo.get(cuisines[i]).add(new CuisineNode(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String currCuisine = foodInfo.get(food).cuisine;
        foodInfo.get(food).rating = newRating;
        cuisineInfo.get(currCuisine).add(new CuisineNode(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        String topFood = cuisineInfo.get(cuisine).peek().food;
        int topRate = cuisineInfo.get(cuisine).peek().rating;
        while(foodInfo.get(topFood).rating != topRate){
            cuisineInfo.get(cuisine).remove();
            topFood = cuisineInfo.get(cuisine).peek().food;
            topRate = cuisineInfo.get(cuisine).peek().rating;
        }
        return (cuisineInfo.get(cuisine).peek().food);
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
