import java.util.*;
public class Day_2 {
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
  //Question 2
   public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
       List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int i = 0;
        res.add( new ArrayList<>());
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                i++;
                
                if(q.isEmpty()){
                        break;
                }else{
                    res.add( new ArrayList<>());
                    q.add(null);
                }
            }else{
                
                res.get(i).add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
  //Question 3
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        int flow = 0;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                
                if(flow == 0){
                    res.add(level);
                    flow = 1;
                }else{
                    for(int i=0; i<level.size()/2; i++){
                        int temp = level.get(i);
                        level.set(i, level.get(level.size()-1-i));
                        level.set(level.size()-1-i, temp);
                    }
                    res.add(level);
                    flow = 0;
                }
                if(q.isEmpty()){
                    return res;
                }
                level = new ArrayList<>();
                q.add(null);
                continue;

            }
            level.add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        return res;
    }
    
  

}
