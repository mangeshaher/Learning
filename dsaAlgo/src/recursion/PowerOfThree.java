package recursion;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if((n%3==0 && n/3==1)||n==1){
            return true;
        }
        else if(n%3==0 && n/3>1){
            return isPowerOfThree(n/3);
        }
        else{
            return false;
        }
    }
}
