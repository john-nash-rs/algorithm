class Solution {
    public int fillCups(int[] amounts) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(int amount : amounts){
            max.add(amount);
        } 

        int timeInSeconds = 0;
        while(max.peek() > 0) {
            int highest = max.poll();
            int secondHighest = max.poll();
            max.add(highest - 1);
            max.add(secondHighest - 1);
            timeInSeconds++;
        }
        
        return timeInSeconds;
    }
}
