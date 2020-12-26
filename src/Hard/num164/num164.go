package num164

func maximumGap(nums []int) int {
	if len(nums) < 2 {
		return 0
	}
	quickSort(nums, 0, len(nums)-1)
	res := 0
	for i := 1; i < len(nums); i++ {
		if nums[i]-nums[i-1] > res {
			res = nums[i] - nums[i-1]
		}
	}
	return res
}

func quickSort(nums []int, l, r int) {
	if l < r {
		i := l
		j := r
		X := nums[l]
		for i < j {
			for i < j && nums[j] >= X {
				j--
			}
			nums[i] = nums[j]
			for i < j && nums[i] < X {
				i++
			}
			nums[j] = nums[i]

		}
		nums[i] = X
		quickSort(nums, l, i-1)
		quickSort(nums, i+1, r)
	}
}
