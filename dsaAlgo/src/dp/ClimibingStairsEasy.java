package dp;

public class ClimibingStairsEasy {
    public int climbStairs(int n) {
        int a[] = new int[n];
        a[0] = 1;
        if(n>1){
            a[1] = 2;
        }
        for(int i=2;i<n;i++){
            a[i] = a[i-1] + a[i-2];//ith step can be reached from i-1 and i-2 step
            //(i-1)th + 1 --> one way and (i-2)th +2 --> second way
        }
        return a[n-1];
    }
}
