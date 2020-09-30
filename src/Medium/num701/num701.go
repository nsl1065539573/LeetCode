package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func main() {
	node1 := &TreeNode{55, nil, nil}
	node2 := &TreeNode{28, nil, nil}
	node3 := &TreeNode{92, nil, nil}
	node4 := &TreeNode{26, nil, nil}
	node5 := &TreeNode{43, nil, nil}
	node1.Left = node2
	node1.Right = node3
	node2.Left = node4
	node4.Right = node5
	insertIntoBST(node1, 1)
}

func insertIntoBST(root *TreeNode, val int) *TreeNode {
	if root == nil {
		return &TreeNode{val, nil, nil}
	}
	cur := root
	for cur != nil {
		if cur.Val > val {
			if cur.Left == nil {
				cur.Left = &TreeNode{val, nil, nil}
				break
			}
			cur = cur.Left
		} else {
			if cur.Right == nil {
				cur.Right = &TreeNode{val, nil, nil}
				break
			}
			cur = cur.Right
		}
	}
	return root
}
