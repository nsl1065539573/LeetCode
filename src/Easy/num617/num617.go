package num617

func mergeTrees(t1 *TreeNode, t2 *TreeNode) *TreeNode {
	if t1 == nil {
		return t2
	}
	if t2 == nil {
		return t1
	}
	domain(t1, t2)
	return t1
}

func domain(t1 *TreeNode, t2 *TreeNode) {
	if t1 == nil || t2 == nil {
		return
	}
	t1.Val = t1.Val + t2.Val
	if t1.Left != nil {
		domain(t1.Left, t2.Left)
	} else {
		t1.Left = t2.Left
	}
	if t1.Right != nil {
		domain(t1.Right, t2.Right)
	} else {
		t1.Right = t2.Right
	}
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
