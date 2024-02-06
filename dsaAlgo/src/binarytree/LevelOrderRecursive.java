package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderRecursive {
    List<List<Integer>> retval = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        int clevel = 0;
        call(clevel, root);
        return retval;
    }

    public void call(int clevel, TreeNode root) {
        if(root==null){
            return;
        }
        if(retval.size() < clevel+1){
            retval.add(new ArrayList<>());
        }
        retval.get(clevel).add(root.val);
        call(clevel+1, root.left);
        call(clevel+1, root.right);
    }
}
