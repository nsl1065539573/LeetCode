package medium.num307;

public class NumArray {
  public static void main(String[] args) {
    NumArray numArray =  new NumArray(new int[]{1, 3, 5});
    System.out.println(numArray.sumRange(0, 2));
    numArray.update(1, 2);
    System.out.println(numArray.sumRange(0, 2));
  }

  // 前缀和，更新的时候更新前缀和

  // 树状数组
  private int[] nums;
  private int[] trees;


  public NumArray(int[] nums) {
    this.nums = nums;
    trees = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      add(i +1, nums[i]);
    }
  }

  private void add(int index, int val) {
    for (int i = index; i < trees.length; i = i + (i & (-i))) {
      trees[i] = trees[i] + val;
    }
  }

  private int query(int x) {
    int ans = 0;
    for (int i = x; i > 0; i = i - (i & (-i))) {
      ans += trees[i];
    }
    return ans;
  }

  public void update(int index, int val) {
    int origin = nums[index];
    int diff = val - origin;
    nums[index] = val;
    add(index +1, diff);
  }

  public int sumRange(int left, int right) {
    return query(right + 1) - query(left);
  }
}
