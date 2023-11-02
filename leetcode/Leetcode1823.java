class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue with friend numbers from 1 to n.
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // Start the elimination process.
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                // Move the friend who didn't get eliminated to the end of the queue.
                int eliminatedFriend = queue.poll();
                queue.offer(eliminatedFriend);
            }
            // Remove the k-th friend who gets eliminated.
            queue.poll();
        }

        // The last remaining friend is the winner.
        return queue.poll();
    }
}