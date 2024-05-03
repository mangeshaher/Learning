package binarytree;

import java.util.*;

/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
(i.e., from left to right, level by level from leaf to root).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
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

public class LeverOrderReverseRecursive {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> retval = new ArrayList<>();
        call(root, retval, 0);
        Collections.reverse(retval);
        return retval;
    }

    public void call(TreeNode root, List<List<Integer>> retval, int l){
        if(root == null){
            return;
        }
        if(retval.size()<l+1){
            retval.add(new ArrayList<>());
        }
        List<Integer> curList = retval.get(l);
        curList.add(root.val);
        call(root.left, retval, l+1);
        call(root.right, retval, l+1);
    }
}
