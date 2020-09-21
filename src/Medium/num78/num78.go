package num78

func subsets(nums []int) [][]int {
	res := make([][]int, 0)
	track := make([]int, 0)
	domain(0, &res, nums, track)
}

func domain(begin int, res *[][]int, nums []int, track []int) {
	temp := make([]int, len(track))
	copy(temp, track)
	*res = append(*res, temp)
	if begin == len(nums) {
		return
	}
	for i := begin; i < len(nums); i++ {
		track = append(track, nums[i])
		domain(i+1, res, nums, track)
		track = track[:len(track)-1]
	}
}
