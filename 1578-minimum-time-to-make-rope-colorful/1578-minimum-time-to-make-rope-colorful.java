class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        int comparedTime = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                res += Math.min(neededTime[i], comparedTime);
                comparedTime = Math.max(neededTime[i], comparedTime);
            } else {
                comparedTime = neededTime[i];
            }
        }

        return res;        
    }
}