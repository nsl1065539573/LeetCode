package num236

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
		if node == left || node == right {
			return true
		}
		return hasLeft || hasRight
	}
	domain(root, p, q)
	return res
}

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}
