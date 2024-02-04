package binarytree;

public class SymettricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null&&root.right==null){
            return true;
        }
        else{
            return isSymmetricMirror(root.left, root.right);
        }
    }

    public boolean isSymmetricMirror(TreeNode left, TreeNode right) {
        if(left==null && null==right){
            return true;
        }
        if(left!=null && null!=right && left.val==right.val){
            return isSymmetricMirror(left.right, right.left) && isSymmetricMirror(left.left, right.right);
        }
        else{
            return false;
        }
    }
}
