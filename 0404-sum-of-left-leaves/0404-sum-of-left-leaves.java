class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return find_val(root,1);
    }
    public static int find_val(TreeNode root,int flag){
        if(root==null) return 0;
        if(flag==0&&root.right==null&&root.left==null) return root.val;
        return find_val(root.left,0)+find_val(root.right,1); 
    }
}