package num538

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func convertBST(root *TreeNode) *TreeNode {
	sum := 0
	var domain func(root *TreeNode)
	domain = func(root *TreeNode) {
		if root == nil {
			return
		}
		domain(root.Right)
		root.Val += sum
		sum = root.Val
		domain(root.Left)
	}
	domain(root)
	return root
}
