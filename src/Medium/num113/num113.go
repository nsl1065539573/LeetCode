package num113

import "fmt"

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func pathSum(root *TreeNode, sum int) [][]int {
	track := make([]int, 0)
	res := make([][]int, 0)
    s := 0
	var domain func(*TreeNode)
 	domain = func(node *TreeNode) {	
		if node == nil {
			return 
		}
        track = append(track, node.Val)
        s += node.Val
        defer func() {
            track = track[:len(track) - 1]
            s -= node.Val
        }()
		if s == sum && node.Left == nil && node.Right == nil {
			res = append(res, append([]int{}, track...))
			return
		}

		domain(node.Left)
		domain(node.Right)
	}
	domain(root)
	return res
}