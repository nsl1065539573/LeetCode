package num94

import "container/list"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
	stack := list.New()
	res := make([]int, 0)
	curr := root
	for {
		if stack.Len() == 0 && curr == nil {
			break
		}
		for {
			if curr == nil {
				break
			}
			stack.PushBack(curr)
			curr = curr.Left
		}
		curr = stack.Remove(stack.Back()).(*TreeNode)
		res = append(res, curr.Val)
		curr = curr.Right
	}
	return res
}
