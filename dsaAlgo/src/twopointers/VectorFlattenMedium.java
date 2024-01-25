package twopointers;

public class VectorFlattenMedium {
    int[] flatVector;
    int next;

    public VectorFlattenMedium(int[][] vec) {
        next = 0;
        int size = 0;
        for(int i=0;i<vec.length;i++){
            size += vec[i].length;
        }
        flatVector = new int[size];
        int last = 0;
        for(int i=0;i<vec.length;i++){
            for(int j=0;j<vec[i].length;j++){
                flatVector[last++] = vec[i][j];
            }
        }
    }

    public int next() {
        return flatVector[next++];
    }

    public boolean hasNext() {
        return next <= (flatVector.length - 1);
    }
}
