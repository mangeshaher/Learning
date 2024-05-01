package kmergeheap;

import java.util.*;

/*
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
Define a pair (u, v) which consists of one element from the first array and one element from the second array.
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

Example 1:
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Constraints:
1 <= nums1.length, nums2.length <= 105
-109 <= nums1[i], nums2[i] <= 109
nums1 and nums2 both are sorted in non-decreasing order.
1 <= k <= 104
k <= nums1.length * nums2.length
*/

public class KPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for(int i=0;i<(k<l1?k:l1);i++){
            for(int j=0;j<(k<l2?k:l2);j++){
                if(q.size()<k){
                    q.offer(new int[]{nums1[i], nums2[j], nums1[i]+nums2[j]});
                }
                else{
                    if(q.peek()[2]>nums1[i]+nums2[j]){
                        q.poll();
                        q.offer(new int[]{nums1[i], nums2[j], nums1[i]+nums2[j]});
                    }
                    else{
                        break;
                    }
                }
            }
        }
        List<List<Integer>> retval = new ArrayList<>();
        for(int i=0;i<k;i++){
            int[] val = q.poll();
            retval.add(Arrays.asList(val[0], val[1]));
        }
        return retval;
    }
}
