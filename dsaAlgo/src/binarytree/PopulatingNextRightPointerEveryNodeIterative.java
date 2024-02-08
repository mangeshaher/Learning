package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointerEveryNodeIterative {
    List<List<Node>> lis = new ArrayList<>();

    public Node connect(Node root) {
        levelOrder(root, 0);
        for(int i=0;i<lis.size();i++){
            for(int j=0;j<lis.get(i).size()-1;j++){
                Node currNode = lis.get(i).get(j);
                Node nextNode = lis.get(i).get(j+1);
                currNode.next = nextNode;
            }
        }
        return root;
    }

    private void levelOrder(Node root, int level){
        if(root == null){
            return;
        }

        if(lis.size() < level+1){
            lis.add(new ArrayList<>());
        }

        lis.get(level).add(root);
        levelOrder(root.left, level+1);
        levelOrder(root.right, level+1);
    }
}
