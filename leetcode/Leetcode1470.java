class Solution {
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        for (int i = 0; i < n; i++) {
            result[i * 2] = nums[i]; // Place elements from the first half at even indices
            result[i * 2 + 1] = nums[i + n]; // Place elements from the second half at odd indices
        }

        return result;
    }
}