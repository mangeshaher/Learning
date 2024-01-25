package twopointers;
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
*/

public class MoveZeroesEasy {
    public void moveZeroes(int[] nums) {
        int i=1;
        int nextNonZero=1;
        while(nextNonZero<nums.length){
            if(nums[i-1]==0){
                if(nums[nextNonZero]!=0){
                    int temp = nums[i-1];
                    nums[i-1] = nums[nextNonZero];
                    nums[nextNonZero] = temp;
                    i++;
                    nextNonZero++;
                }
                else{
                    nextNonZero++;
                }
            }
            else{
                i++;
                nextNonZero++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroesEasy moveZeroes = new MoveZeroesEasy();
        int[] arr = new int[]{0,0,0,1,0,7,8};
        moveZeroes.moveZeroes(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}