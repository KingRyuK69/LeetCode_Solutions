class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;  // Indicates if the array is increasing
        boolean isDecreasing = true;  // Indicates if the array is decreasing

        // Check if the array is either increasing or non-increasing
        for (int i = 1; i < nums.length; i++) {
            // Check increasing condition.
            if (nums[i] < nums[i - 1])
                isIncreasing = false;

            // Check decreasing condition.
            else if (nums[i] > nums[i - 1])
                isDecreasing = false;

            // If it is neither increasing nor decreasing then don't continue the loop
            if (!isIncreasing && !isDecreasing)
                break;
        }

        return isIncreasing || isDecreasing;  // Return true if either condition is met
    }
}