package binarytree;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/

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
