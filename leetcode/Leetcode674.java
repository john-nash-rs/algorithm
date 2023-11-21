class Solution {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // Current element is greater than the previous one, so the sequence is increasing
                currentLength++;
            } else {
                // Reset the length if the sequence is not strictly increasing
                currentLength = 1;
            }

            // Update the maximum length
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
