package binarytree;

import java.util.*;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you
can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:
Input: root = [1,null,3]
Output: [1,3]
Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

public class RightSideView {
    List<Integer> retval;
    public List<Integer> rightSideView(TreeNode root) {
        retval = new ArrayList<>();
        call(root, 0);
        return retval;
    }

    private void call(TreeNode root, int level){
        if(root!=null){
            if(retval.size()<level+1){
                retval.add(root.val);
            }
            call(root.right, level+1);
            call(root.left, level+1);
        }
    }
}
