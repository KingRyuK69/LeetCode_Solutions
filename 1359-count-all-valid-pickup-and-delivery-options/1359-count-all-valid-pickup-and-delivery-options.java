class Solution {
    private long[][] dp;
    private static final int MOD = 1000000007;

    private long solve(int notpickup, int notdelivered) {
        if (notpickup == 0 && notdelivered == 0) {
            return 1;
        }
        if (notpickup < 0 || notdelivered < 0 || notpickup > notdelivered) {
            return 0;
        }

        if (dp[notpickup][notdelivered] != -1) {
            return dp[notpickup][notdelivered];
        }

        long res = 0;

        res = (res + notpickup * solve(notpickup - 1, notdelivered)) % MOD;

        res = (res + (notdelivered - notpickup) * solve(notpickup, notdelivered - 1)) % MOD;

        return dp[notpickup][notdelivered] = res;
    }

    public int countOrders(int n) {
        dp = new long[n + 1][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return (int) solve(n, n);
    }
}