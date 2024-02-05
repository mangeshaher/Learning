package binarytree;

import java.util.HashMap;

public class BinaryTreeFromInorderPostOrder {
    int postIndex=0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return constructTree(postorder, 0, postorder.length - 1);
    }

    public TreeNode constructTree(int[] postorder, int l, int r) {
        if(l>r){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex--]);
        root.right = constructTree(postorder, map.get(root.val) + 1, r);
        root.left = constructTree(postorder, l, map.get(root.val) - 1);
        return root;
    }
}
