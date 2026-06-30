import java.util.*;
public class Day_4 {
  //Question 1
  class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
          if (root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}
  //Question 2
  class Solution {
     int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       
        height(root);
        return diameter;
        
    }
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left,right);
    }
} 
  //Question 3
  class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,dfs(node.left));
        int right = Math.max(0,dfs(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);
        return node.val + Math.max(left,right);
    }
}
    

}
