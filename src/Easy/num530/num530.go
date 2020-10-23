package num530

import (
	"fmt"
	"math"
)

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

/**
中序遍历，有序数组
记录min，pre
当前节点要做的事：减去pre，与min比较，把自己赋值给pre
 */
func getMinimumDifference(root *TreeNode) int {
	pre := &TreeNode{
		Val: math.MinInt16,
	}
	min := math.MaxInt32
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Left)
		if pre != nil {
			fmt.Printf("打印pre：：：：：%v\n", pre.Val)
			fmt.Printf("打印node：：：：：%v\n", node.Val)
			res := node.Val - pre.Val
			if min > res {
				min = res
			}
		}
		pre = node
		dfs(node.Right)
	}
	dfs(root)
	return min
}
