package binarytree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root!=null){
            if(root.left==null && root.right==null){
                return (targetSum - root.val == 0) ? true : false;
            }
            else{
                return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
            }
        }
        else{
            return false;
        }
    }
}
