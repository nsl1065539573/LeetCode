package num75

func sortColors(nums []int) {
	temp := make([]int, 3)
	for i := 0; i < len(nums); i++ {
		temp[nums[i]] += 1
	}
	index := 0
	for i := 0; i < 3; i++ {
		for j := 0; j < temp[i]; j++ {
			nums[index] = i
			index += 1
		}
	}
}
