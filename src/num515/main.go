package num515

import "math"

func largestValues(root *TreeNode) []int {
	res := []int{}
	if root == nil {
		return res
	}
	list := []*TreeNode{}
	list = append(list, root)
	cur := 1
	for len(list) > 0 && cur > 0 {
		max := math.MinInt64
		cur = len(list)
		for i := 0; i < cur; i++ {
			temp := list[0]
			list = list[1:]
			if temp.Val > max {
				max = temp.Val
			}
			if temp.Left != nil {
				list = append(list, temp.Left)
			}
			if temp.Right != nil {
				list = append(list, temp.Right)
			}
		}
		res = append(res, max)
	}
	return res
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
