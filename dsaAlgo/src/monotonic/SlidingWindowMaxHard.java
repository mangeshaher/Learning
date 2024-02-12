package monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaxHard {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] retval = new int[nums.length - k + 1];
        Deque<Integer> que = new ArrayDeque<>();
        int left = 0;
        int right = k-1;
        que.offerLast(left);
        for(int i=left+1;i<=right;i++){
            while(!que.isEmpty() && nums[que.peekLast()] < nums[i]){
                que.pollLast();
            }
            que.offerLast(i);
        }
        retval[0] = nums[que.peekFirst()];
        for(int i=1;i<=nums.length-k;i++){
            //System.out.println("for i :- " + i);
            //que.stream().forEach(System.out::println);
            if(que.peekFirst() == i-1){
                que.pollFirst();
            }
            while(!que.isEmpty() && nums[que.peekLast()] < nums[right+i]){
                que.pollLast();
            }
            que.offerLast(right + i);
            retval[i] = nums[que.peekFirst()];
        }
        return retval;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;

        for(int i : maxSlidingWindow(nums, k)){
            System.out.println("*******");
            System.out.println(i);
        }
        //System.out.println(maxSlidingWindow(nums, k));
    }
}
