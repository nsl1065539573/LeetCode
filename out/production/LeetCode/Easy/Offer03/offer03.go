package Offer03

/**
剑指offer 03
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func findRepeatNumber(nums []int) int {
	// 1. 建立一个int切片长度为n
	// 2. 遍历nums，nums[i]作为下标，给int数组对应的下标的值加一
	// 3. 每次相加判断，如果大于1，则直接返回，不大于就继续遍历
	times := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		times[nums[i]] = times[nums[i]] + 1
		if times[nums[i]] > 1 {
			return nums[i]
		}
	}
	return -1
}
