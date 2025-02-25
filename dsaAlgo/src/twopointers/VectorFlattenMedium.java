package twopointers;

/*
Design an iterator to flatten a 2D vector. It should support the next and hasNext operations.
Implement the Vector2D class:
Vector2D(int[][] vec) initializes the object with the 2D vector vec.
next() returns the next element from the 2D vector and moves the pointer one step forward. You may assume that all the calls to next are valid.
hasNext() returns true if there are still some elements in the vector, and false otherwise.

Example 1:
Input
["Vector2D", "next", "next", "next", "hasNext", "hasNext", "next", "hasNext"]
[[[[1, 2], [3], [4]]], [], [], [], [], [], [], []]
Output
[null, 1, 2, 3, true, true, 4, false]

Explanation
Vector2D vector2D = new Vector2D([[1, 2], [3], [4]]);
vector2D.next();    // return 1
vector2D.next();    // return 2
vector2D.next();    // return 3
vector2D.hasNext(); // return True
vector2D.hasNext(); // return True
vector2D.next();    // return 4
vector2D.hasNext(); // return False

Constraints:

0 <= vec.length <= 200
0 <= vec[i].length <= 500
-500 <= vec[i][j] <= 500
At most 105 calls will be made to next and hasNext.
*/
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
