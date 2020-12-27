package main

import "fmt"

type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}

func main(){
	node1 := &TreeNode{6,nil,nil}
	node2 := &TreeNode{2,nil,nil}
	node3 := &TreeNode{8,nil,nil}
	node4 := &TreeNode{0,nil,nil}
	node5 := &TreeNode{4,nil,nil}
	node6 := &TreeNode{7,nil,nil}
	node7 := &TreeNode{9,nil,nil}
	node8 := &TreeNode{3,nil,nil}
	node9 := &TreeNode{5,nil,nil}
	node1.Left = node2
	node1.Right = node3
	node2.Left = node4
	node2.Right = node5
	node3.Left = node6
	node3.Left = node7
	node5.Left = node8
	node5.Right = node9
	lowestCommonAncestor(node1, node4, node7)
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var res *TreeNode
	var domain func(node, left, right *TreeNode) bool
	domain = func(node, left, right *TreeNode) bool {
		if node == nil {
			return false
		}
		hasLeft := domain(node.Left, left, right)
		hasRight := domain(node.Right, left, right)
		if hasLeft && hasRight {
			res = node
			return true
		}
		if hasLeft && (node == left || node == right) {
			res = node
			return true
		}
		if hasRight && (node == left || node == right) {
			res = node
			return true
		}
		fmt.Printf("打印一下root%v\n", node.Val)
		if node == left || node == right {
			return true
		}
		return hasLeft || hasRight
	}
	domain(root, p, q)
	fmt.Printf("打印一下res%v",res.Val)
	return res
}
