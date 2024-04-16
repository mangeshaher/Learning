package slidingwindow.fixedwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the
array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one
position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/
public class SlidingWindowMaxHard {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int l = nums.length;
        int[] retval = new int[l - k + 1];
        Deque<Integer> que = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        while(right<l){
            while(que.size()>0 && que.peekLast()<nums[right]){
                que.pollLast();
            }
            que.offerLast(nums[right]);

            if(right-left+1<k){
                right++;
            }
            else if(right-left+1==k){
                retval[left] = que.peekFirst();
                if(que.peekFirst()==nums[left]){
                    que.pollFirst();
                }
                left++;
                right++;
            }
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
