package binarytree;

import java.util.*;

/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

Constraints:
The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
*/

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        List<Integer> retval = new ArrayList<>();
        call(retval, 0, root);
        int msum=Integer.MIN_VALUE;
        int maxl=0;
        for(int i=0;i<retval.size();i++){
            if(retval.get(i)>msum){
                msum = retval.get(i);
                maxl = i + 1;
            }
        }
        return maxl;
    }

    public void call(List<Integer> retval, int clevel, TreeNode root) {
        if(root==null){
            return;
        }
        if(retval.size() < clevel+1){
            retval.add(0);
        }
        retval.set(clevel, retval.get(clevel) + root.val);
        call(retval, clevel+1, root.left);
        call(retval, clevel+1, root.right);
    }
}
