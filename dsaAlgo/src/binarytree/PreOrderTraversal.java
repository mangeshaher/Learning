package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if(root != null){
            preorderIterative(root, retList);
        }
        return retList;
    }

    public void preorderIterative(TreeNode root, List<Integer> retList){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode n = s.pop();
            retList.add(n.val);
            if(n.right!=null){
                s.push(n.right);
            }
            if(n.left!=null){
                s.push(n.left);
            }
        }
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if(root != null){
            preorderRecursive(root, retList);
        }
        return retList;
    }

    public void preorderRecursive(TreeNode root, List<Integer> retList){
        retList.add(root.val);
        if(root.left!=null){
            preorderRecursive(root.left, retList);
        }
        if(root.right!=null){
            preorderRecursive(root.right, retList);
        }
    }

}
