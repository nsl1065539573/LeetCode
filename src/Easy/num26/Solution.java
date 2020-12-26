package Easy.num26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pre) {
                pre = nums[i];
                nums[index] = nums[i];
                index ++;
            }
        }
        return index;
    }
}
