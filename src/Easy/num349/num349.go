package num349

func intersection(nums1 []int, nums2 []int) []int {
	res := make([]int, 0)
	set := map[int]struct{}{}
	temp := map[int]struct{}{}
	for i := 0; i < len(nums1); i++ {
		set[nums1[i]] = struct{}{}
	}
	for i := 0; i < len(nums2); i++ {
		if _, ok := set[nums2[i]]; ok {
			if _, has := temp[nums2[i]]; !has {
				res = append(res, nums2[i])
				temp[nums2[i]] = struct{}{}
			}
		}
	}
	return res
}
