package num27

func removeElement(nums []int, val int) int {
	var index int = 0
	for i := 0; i < len(nums); i++ {
		if (nums[i] != val) {
			nums[index] = nums[i]
			index++
		}
	}
	return index + 1
}