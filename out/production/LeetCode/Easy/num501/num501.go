package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	node1 := &TreeNode{1, nil, nil}
	node2 := &TreeNode{2, nil, nil}
	node3 := &TreeNode{2, nil, nil}
	node1.Right = node2
	node2.Left = node3
	findMode(node1)
}

func findMode(root *TreeNode) []int {
	res := make([]int, 0)
	val := 0
	times := 0
	max := 0
	var domain func(root *TreeNode)
	domain = func(root *TreeNode) {
		if root == nil {
			return
		}
		domain(root.Left)
		if root.Val == val {
			times = times + 1
		} else {
			times = 1
		}
		if times > max {
			max = times
			res = res[0:0]
			fmt.Printf("time > max, val is %v, times is %v, max is %v \n", root.Val, times, max)
		}
		if times == max {
			res = append(res, root.Val)
			fmt.Printf("time == max, val is %v, times is %v, max is %v \n", root.Val, times, max)
		}
		val = root.Val
		domain(root.Right)
	}
	domain(root)
	fmt.Println(res)
	return res
}
