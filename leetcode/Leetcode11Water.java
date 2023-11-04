class Solution {
    public int maxArea(int[] height) {
    int left = 0; // Initialize the left pointer to the beginning of the array.
    int right = height.length - 1; // Initialize the right pointer to the end of the array.
    int maxArea = 0; // Initialize the maximum area to 0.

    while (left < right) {
        // Calculate the width of the container (the x-axis distance between the two lines).
        int width = right - left;

        // Calculate the height of the container (the minimum height of the two lines).
        int minHeight = Math.min(height[left], height[right]);

        // Calculate the area of the container and update maxArea if it's greater.
        int currentArea = width * minHeight;
        maxArea = Math.max(maxArea, currentArea);

        // Move the pointers to potentially find a larger container.
        if (height[left] < height[right]) {
            left++; // Move the left pointer to the right.
        } else {
            right--; // Move the right pointer to the left.
        }
    }

    return maxArea;
    }
}