class Solution {
        public int distributeCandies(int[] candyType) {
            int n = candyType.length;
            int maxTypes = n / 2;

            HashSet<Integer> uniqueCandies = new HashSet<>();
            for (int candy : candyType) {
                uniqueCandies.add(candy);

                // Check if Alice can eat n / 2 types of candies
                if (uniqueCandies.size() == maxTypes) {
                    return maxTypes;
                }
            }

            // If there are fewer types of candies than n / 2
            return uniqueCandies.size();
    }
}
