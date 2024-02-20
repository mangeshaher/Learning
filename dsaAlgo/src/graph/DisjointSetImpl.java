package graph;

public class DisjointSetImpl {
    int[] root;
    int[] rank;

    public void solve() {
        int n = 10;
        root = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            root[i] = i;
            rank[i] = i;
        }
    }

    public void union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);
        if(rootI != rootJ){
            if(rank[rootI] > rank[rootJ]){
                root[rootJ] = rootI;
            }
            else if(rank[rootI] < rank[rootJ]){
                root[rootI] = rootJ;
            }
            else{
                root[rootJ] = rootI;
                //depth of rootI is increased....
                rank[rootI]++;
            }
        }
    }

    public int find(int i){
        if(root[i] == i){
            return i;
        }
        return root[i] = find(root[i]);
    }

    public static void main(String[] args) {
        DisjointSetImpl disjointSet = new DisjointSetImpl();
        disjointSet.solve();
    }
}
