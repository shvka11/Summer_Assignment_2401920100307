
 import java.util.*; 
public class Day_5 {
  // Question 1
  class Solution {
    public boolean isSymmetric(TreeNode root) {
       if(root == null)
        return true;

        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null)
        return true;

        if(left == null || right == null)
        return false;

        if(left.val != right.val)
        return false;

        return isMirror(left.left, right.right)
        && isMirror(left.right, right.left);
 
    }
}
  //Question 2
  class Solution {
     HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);

        }

        return helper(preorder,0,inorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int left, int right){

        if(left > right)
        return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);

        return root;
    


        
    }
}  
    

}
