package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if(root != null){
            postorderIterative(root, retList);
        }
        return retList;
    }

    public void postorder(TreeNode root, List<Integer> retList){
        if(root.left != null){
            postorder(root.left, retList);
        }
        if(root.right != null){
            postorder(root.right, retList);
        }
        retList.add(root.val);
    }

    public void postorderIterative(TreeNode root, List<Integer> retList){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        //s.push(root);
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode top = s1.pop();
            s2.push(top);
            if(top.left!=null){
                s1.push(top.left);
            }
            if(top.right!=null){
                s1.push(top.right);
            }
        }
        while(!s2.isEmpty()) {
            retList.add(s2.pop().val);
        }
    }
}
