class Solution {
    int[] pilesGlobal = new int[500]; 
    Map<String, Integer> memory = new HashMap<>();
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            total = total + piles[i];
            pilesGlobal[i] = piles[i];
        }
        int aliceStone = countStoneForAlice(0, n - 1); 
        //System.out.println("aliceStone "+aliceStone);       
        if(aliceStone > (total - aliceStone)){
            return true;
        }

        return false;
    }

    private int countStoneForAlice(int start, int end){
        if(end < start){
            return 0;
        }
        String key = start + "," + end;
        Integer value = memory.get(key);
        if(value != null){
            return value;
        }
        int aliceStoneIfPickedFirst = 0;
        aliceStoneIfPickedFirst = aliceStoneIfPickedFirst + pilesGlobal[start];
        //if bob picks first
        int alicaStoneIfBobPicksFirstOfRemaining = countStoneForAlice(start+2, end);
        //if bob picks last
        int alicaStoneIfBobPicksLastOfRemaining = countStoneForAlice(start+1, end-1);

        //Since bob would want to play to win. he would want alice to have less stone
        if(alicaStoneIfBobPicksFirstOfRemaining < alicaStoneIfBobPicksLastOfRemaining){
            aliceStoneIfPickedFirst = aliceStoneIfPickedFirst + alicaStoneIfBobPicksFirstOfRemaining;
        } else {
            aliceStoneIfPickedFirst = aliceStoneIfPickedFirst + alicaStoneIfBobPicksLastOfRemaining;
        }

        int aliceStoneIfPickedLast = 0;
        aliceStoneIfPickedLast = aliceStoneIfPickedLast + pilesGlobal[end];

        //if bob picks first
        alicaStoneIfBobPicksFirstOfRemaining = countStoneForAlice(start+1, end-1);
        //if bob picks last
        alicaStoneIfBobPicksLastOfRemaining = countStoneForAlice(start, end-2);

        //Since bob would want to play to win. he would want alice to have less stone
        if(alicaStoneIfBobPicksFirstOfRemaining < alicaStoneIfBobPicksLastOfRemaining){
            aliceStoneIfPickedLast = aliceStoneIfPickedLast + alicaStoneIfBobPicksFirstOfRemaining;
        } else {
            aliceStoneIfPickedLast = aliceStoneIfPickedLast + alicaStoneIfBobPicksLastOfRemaining;
        }

        //Alice would want more stones
        
        if(aliceStoneIfPickedFirst > aliceStoneIfPickedLast) {
            memory.put(key, aliceStoneIfPickedFirst);
            return aliceStoneIfPickedFirst;
        }
        memory.put(key, aliceStoneIfPickedLast);
        return aliceStoneIfPickedLast;
    }
}