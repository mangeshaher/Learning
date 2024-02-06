package binarytree;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to
right, then right to left for the next level and alternate between).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZag {
    List<List<Integer>> retval = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int clevel = 0;
        call(clevel, root);
        for(int i=0;i<retval.size();i++){
            if(i%2==1){
                retval.set(i, retval.get(i).reversed());
            }
        }
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
