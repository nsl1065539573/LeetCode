package offer27

func mirrorTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	// 这次用前序遍历做
	preOrder(root)
	return root
}

func preOrder(root *TreeNode) {
	if root == nil {
		return 
	}
	temp := root.Left
	root.Left = root.Right
	root.Right = temp
	preOrder(root.Left)
	preOrder(root.Right)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
