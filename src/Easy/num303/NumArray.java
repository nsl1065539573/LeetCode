package Easy.num303;

public class NumArray {
  private final int[] data;

  public NumArray(int[] nums) {
    this.data = nums;
  }

  public int sumRange(int i, int j) {
    int res = 0;
    for (int k = i; k <= j; k++) {
      res += data[k];
    }
    return res;
  }
}
