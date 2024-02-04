package binarytree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            return 1+Integer.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
