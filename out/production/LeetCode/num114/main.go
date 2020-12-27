package main

func flatten(root *TreeNode) {
	if root == nil {
		return
	}
	flatten(root.Left)
	flatten(root.Right)

	// 当前节点的右子节点变为左子节点
	temp := root.Right
	root.Right = root.Left
	root.Left = nil
	for root.Right != nil {
		root = root.Right
	}
	root.Right = temp
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
