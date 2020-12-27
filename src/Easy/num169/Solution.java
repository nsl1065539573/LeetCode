package Easy.num169;

import java.util.HashMap;

public class Solution {
    //    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.merge(num, 1, Integer::sum);
//        }
//        for (Integer item:
//             map.keySet()) {
//            if (map.get(item) > nums.length / 2) {
//                return item;
//            }
//        }
//        return 0;
//    }
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                if (--count == 0) {
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }
}
