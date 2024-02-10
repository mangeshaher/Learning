package dfs;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, collect a tree's nodes as if you were doing this:
Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.

Example 1:
Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter
the order on which elements are returned.
Example 2:
Input: root = [1]
Output: [[1]]

Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
*/

public class LeavesOfBinaryTree {
    List<List<Integer>> leaves;
    public List<List<Integer>> findLeaves(TreeNode root) {
        leaves = new ArrayList<>();
        int h = height(root);
        for(int i=0;i<=h;i++){
            leaves.add(new ArrayList<>());
            dfs(root, i);
        }
        return leaves;
    }

    public int height(TreeNode root){
        if(isLeaf(root)||root==null){
            return 0;
        }
        return Integer.max(1+height(root.left), 1+height(root.right));
    }

    public void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }

        if(isLeaf(root)){
            leaves.get(level).add(root.val);
        }

        if(isLeaf(root.left)){
            leaves.get(level).add(root.left.val);
            root.left = null;
        }
        else{
            dfs(root.left, level);
        }

        if(isLeaf(root.right)){
            leaves.get(level).add(root.right.val);
            root.right = null;
        }
        else{
            dfs(root.right, level);
        }
    }

    public boolean isLeaf(TreeNode root){
        if(root==null){
            return false;
        }

        if(root.left == null && root.right == null){
            return true;
        }
        else{
            return false;
        }
    }
}
