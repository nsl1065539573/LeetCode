package num687

func longestUnivaluePath(root *TreeNode) int {
	if root == nil {
		return 0
	}
	var domain func(roor *TreeNode) int
	var res int = 0
	domain = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		var left = domain(root.Left)
		var right = domain(root.Right)
		var length int
		var leftLen int = 0
		var rightLen int = 0
		if root.Left != nil && root.Left.Val == root.Val {
			leftLen = left + 1
		}
		if root.Right != nil && root.Right.Val == root.Val {
			rightLen = right + 1
		}
		length = leftLen + rightLen
		if length > res {
			res = length
		}
		if leftLen > rightLen {
			return leftLen
		} else {
			return rightLen
		}
	}
	domain(root)
	return res
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
