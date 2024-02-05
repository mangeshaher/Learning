package binarytree;

import java.util.HashMap;

public class BinaryTreeFromPreInOrder {
    int preIndex=0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return constructTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode constructTree(int[] preorder, int l, int r) {
        if(l>r){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);

        root.left = constructTree(preorder, l, map.get(root.val) - 1);
        root.right = constructTree(preorder, map.get(root.val) + 1, r);
        return root;
    }
}
