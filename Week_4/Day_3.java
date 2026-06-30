public class Day_3 {
   public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
  //Question 1
   public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }else if(root.val > val){
            return searchBST(root.left , val);
        }else{
            return searchBST(root.right, val);
        }
    }
//Question 2
   public boolean helper(TreeNode root, long max, long min){
        if(root == null) return true;

        if(root.val < max && root.val > min){
            return helper(root.left, root.val, min) && helper(root.right, max, root.val);
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
  //Question 3
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left , p , q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right , p , q);
        }else{
            return root;
        }
    }
}
