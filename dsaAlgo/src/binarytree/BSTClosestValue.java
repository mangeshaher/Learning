package binarytree;

/*
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
If there are multiple answers, print the smallest.

Example 1:
Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:
Input: root = [1], target = 4.428571
Output: 1

Constraints:
The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
*/

public class BSTClosestValue {
    double diff = Double.MAX_VALUE;
    int closest = 0;

    public int closestValue(TreeNode root, double target) {
        if(root!=null){
            if(Math.abs(root.val-target) <= diff ){
                closest = (Math.abs(root.val-target) == diff) ? Integer.min(closest, root.val) :root.val;
                diff = Math.abs(root.val-target);
            }
            if(root.val>target){
                closest = closestValue(root.left, target);
            }
            else{
                closest = closestValue(root.right, target);
            }
        }
        return closest;
    }
}
