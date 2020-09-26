package main

import "fmt"

func main() {
	res := combine(4, 2)
	fmt.Println("res:", res)
}

func combine(n int, k int) [][]int {
	res := make([][]int, 0)
	track := make([]int, 0)
	// backTrack(&res, &track, n, k, 1)
	backTrackNoPoint(res, track, n, k, 1)
	return res
}

func backTrack(res *[][]int, track []int, n, k, begin int) {
	cur := make([]int, len(track))
	copy(cur, track)
	fmt.Println(cur)
	if len(track) == k {
		*res = append(*res, cur)
		return
	}
	for i := begin; i <= n; i++ {
		track = append(track, i)
		backTrack(res, track, n, k, i+1)
		track = cur[:len(cur)]
	}
}

func backTrackNoPoint(res [][]int, track []int, n, k, begin int) {
	cur := make([]int, len(track))
	copy(cur, track)
	fmt.Println(cur)
	if len(track) == k {
		res = append(res, cur)
		return
	}
	for i := begin; i <= n; i++ {
		track = append(track, i)
		backTrackNoPoint(res, track, n, k, i+1)
		track = cur[:len(cur)]
	}
}
