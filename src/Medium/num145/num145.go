package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func main() {
	node1 := &TreeNode{1, nil, nil}
	node2 := &TreeNode{2, nil, nil}
	node3 := &TreeNode{3, nil, nil}
	node1.Right = node2
	node2.Left = node3
	postorderTraversal(node1)
}

func postorderTraversal(root *TreeNode) []int {
	stack := []*TreeNode{root}
	res := []int{}
	for len(stack) > 0 {
		root = stack[len(stack) - 1]
		stack = stack[:len(stack) - 1]
		for root.Left != nil {
			temp := root.Left
			root.Left = nil
			stack = append(stack, root)
			root = temp
		}
		stack = append(stack, root)

		if root.Right != nil {
			stack = append(stack, root.Right)
			root.Right = nil
		} else {
			fmt.Printf("打印root%v\n", root)
			res = append(res, root.Val)
			stack = stack[:len(stack) - 1]
		}
	}
	return res
}
