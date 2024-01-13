class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode r, int mn, int mx) {
        if (r == null) {
            return mx - mn;
        }
        mn = Math.min(mn, r.val);
        mx = Math.max(mx, r.val);

        int leftDiff = helper(r.left, mn, mx);
        int rightDiff = helper(r.right, mn, mx);

        return Math.max(leftDiff, rightDiff);
    }
}