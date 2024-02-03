package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if(root != null){
            inorderIterative(root, retList);
        }
        return retList;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if(root != null){
            inorderRecursive(root, retList);
        }
        return retList;
    }

    public void inorderRecursive(TreeNode root, List<Integer> retList){
        if(root.left != null){
            inorderRecursive(root.left, retList);
        }
        retList.add(root.val);
        if(root.right != null){
            inorderRecursive(root.right, retList);
        }
    }

    public void inorderIterative(TreeNode root, List<Integer> retList){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            while(root.left!=null){
                s.push(root.left);
                root = root.left;
            }
            TreeNode top = s.pop();
            retList.add(top.val);
            if(top.right!=null){
                s.push(top.right);
                root = top.right;
            }
        }
    }
}
