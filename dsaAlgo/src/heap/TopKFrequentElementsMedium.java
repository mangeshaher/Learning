package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class TopKFrequentElementsMedium {
    public int[] topKFrequent(int[] nums, int k) {
        int[] retval = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q =
                new PriorityQueue<>(k, (e1, e2) -> e2.getValue()-e1.getValue());
        map.entrySet().forEach(e -> q.offer(e));
        for(int i=0;i<k;i++){
            retval[i] = q.poll().getKey();
        }
        return retval;
    }
}