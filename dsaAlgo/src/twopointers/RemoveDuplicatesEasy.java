package twopointers;

import java.util.*;
/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
*/

public class RemoveDuplicatesEasy {
    public int removeDuplicatesUnordered(Integer[] nums) {
        int first = 0;
        int nextUnique = 0;
        Set<Integer> set = new HashSet<>();
        while(nextUnique<nums.length){
            if(set.contains(nums[first])){
                if(set.contains(nums[nextUnique])){
                    nextUnique++;
                }
                else{
                    set.add(nums[nextUnique]);
                    int temp = nums[first];
                    nums[first] = nums[nextUnique];
                    nums[nextUnique] = temp;
                    first++;
                    nextUnique++;
                }
            }
            else{
                set.add(nums[first]);
                first++;
                nextUnique++;
            }
        }
        return first;
    }

    //We don't care for first pointer we just want to get unique elements at start
    public int removeDuplicatesOrdered(Integer[] nums) {
        int first = 1;
        int nextUnique = 1;
        while(nextUnique<nums.length) {
            if(nums[nextUnique] != nums[nextUnique-1]){
                nums[first] = nums[nextUnique];
                first++;
            }
            nextUnique++;
        }
        return first;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{5,1,2,6,2,1,5,6};
        Integer[] numsOrdered = new Integer[]{1,1,2,2,5,5,6,6};
        RemoveDuplicatesEasy removeDuplicates = new RemoveDuplicatesEasy();
        removeDuplicates.removeDuplicatesUnordered(nums);
        removeDuplicates.removeDuplicatesOrdered(numsOrdered);
        Arrays.asList(nums).forEach(System.out::print);
        Arrays.asList(numsOrdered).forEach(System.out::println);
    }
}
