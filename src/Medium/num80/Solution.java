package Medium.num80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre = nums[0] - 1;
        int times = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pre || (nums[i] == pre && times < 2)) {
                nums[index] = nums[i];
                if (pre < nums[i]) {
                    times = 1;
                } else {
                    times++;
                }
                pre = nums[i];
                index++;

            }
        }
        return index;
    }
}
