package main

import "fmt"

func main() {
	var nums []int = []int{2, 2, 1, 1}
	res := permuteUnique(nums)
	fmt.Println(res)
}

func permuteUnique(nums []int) [][]int {
	res := make([][]int, 0)
	backTrackv2(0, nums, &res)
	return res
}

func backTrack(begin int, nums []int, visited []bool, track []int, res *[][]int) {
	if len(track) == len(nums) {
		temp := make([]int, len(track))
		copy(temp, track)
		if !contains(temp, *res) {
			*res = append(*res, temp)
		}
		return
	}
	for i := 0; i < len(nums); i++ {
		if visited[i] {
			continue
		}
		if i != begin && nums[i] == nums[begin] {
			continue
		}
		track = append(track, nums[i])
		visited[i] = true
		// fmt.Printf("递归之前的track%v num[i] %v i %v\n", track, nums[i], i)
		backTrack(begin+1, nums, visited, track, res)
		// fmt.Printf("递归之后的track%v\n", track)
		track = track[:len(track)-1]
		visited[i] = false
		// fmt.Printf("裁剪之后的track%v\n", track)
	}
}

func contains(target []int, item [][]int) bool {
	for i := 0; i < len(item); i++ {
		if testEq(target, item[i]) {
			return true
		}
	}
	return false
}

func backTrackv2(begin int, nums []int, res *[][]int) {
	if begin == len(nums)-1 {
		temp := make([]int, len(nums))
		copy(temp, nums)
		*res = append(*res, temp)
		return
	}
	m := map[int]bool{}
	visited := make([]bool, len(nums))
	for i := begin; i < len(nums); i++ {
		// if _, ok := m[nums[i]]; ok {
		// 	continue
		// }
		if visited[nums[i]] {
			continue
		}
		fmt.Printf("map is %v \n", m)
		fmt.Printf("visited is %v\n", visited)
		nums[i], nums[begin] = nums[begin], nums[i]
		visited[nums[i]] = true
		// fmt.Printf("递归之前的track%v num[i] %v i %v\n", track, nums[i], i)
		backTrackv2(begin+1, nums, res)
		// fmt.Printf("递归之后的track%v\n", track)
		nums[i], nums[begin] = nums[begin], nums[i]
		m[nums[i]] = true
		// visited[nums[i]] = true
		// fmt.Printf("裁剪之后的track%v\n", track)
	}
}

func testEq(a, b []int) bool {
	// If one is nil, the other must also be nil.
	if (a == nil) != (b == nil) {
		return false
	}

	if len(a) != len(b) {
		return false
	}

	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}

	return true
}
