package binarytree;

import java.util.*;

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:
Input: root = [1]
Output: ["1"]

Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
*/

public class AllPathsToLeaf {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retval = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        call(root, sb, retval);
        return retval;
    }

    public void call(TreeNode root, StringBuilder path, List<String> retval){
        if(root!=null){
            int l = path.length();
            path.append(root.val);
            if(root.left==null && root.right==null){
                retval.add(path.toString());
            }
            else{
                path.append("->");
                call(root.left, path, retval);
                call(root.right, path, retval);
            }
            path.setLength(l);
        }
    }
}
