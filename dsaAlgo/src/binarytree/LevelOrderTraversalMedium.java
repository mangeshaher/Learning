package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalMedium {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> retval = new ArrayList<>();
        if(root!=null){
            q.offer(root);
            q.offer(new TreeNode(Integer.MIN_VALUE, null, null));
        }
        List<Integer> levelOrder = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val == Integer.MIN_VALUE && curr.left == null && curr.right == null){
                retval.add(levelOrder);
                levelOrder = new ArrayList<>();
                if(q.peek()!=null){
                    q.offer(new TreeNode(Integer.MIN_VALUE, null, null));
                }
            }
            else{
                levelOrder.add(curr.val);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
        }
        return retval;
    }
}
