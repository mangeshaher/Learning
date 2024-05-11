package binarytree;

import java.util.*;

/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom,
column by column).
If two nodes are in the same row and column, the order should be from left to right.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Example 2:
Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
Example 3:
Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

public class VerticalOrderTraversal {
    List<List<List<Integer>>> retval;
    int minIndex = Integer.MAX_VALUE;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        retval = new ArrayList<>();
        minIndex = call(root, 0, 0);
        List<List<Integer>> retva = new ArrayList<>();
        for(List<List<Integer>> lis:retval){
            for(List<Integer> li:lis){
                while(retva.size()<li.get(1)-minIndex+1){
                    retva.add(new ArrayList<>());
                }
                retva.get(li.get(1)-minIndex).add(li.get(0));
            }
        }
        return retva;
    }

    public int call(TreeNode root, int level, int index){
        if(root!=null){
            minIndex = Integer.min(minIndex, index);
            if(retval.size()<level+1){
                retval.add(new ArrayList<>());
            }
            retval.get(level).add(Arrays.asList(root.val, index));
            call(root.left, level+1, index-1);
            call(root.right, level+1, index+1);
        }
        return minIndex;
    }
}
