package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])!=i && Math.abs(map.get(nums[i]) - i) <=k){
                    return true;
                }
                map.put(nums[i], i);
            }
            else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        int i=0;
        int j=1;
        while(j<nums.length){
            while(j<nums.length && Math.abs(i-j) <= k){
                if(nums[i] == nums[j]){
                    return true;
                }
                j++;
            }
            i++;
            j=i+1;
        }
        return false;
    }
}
