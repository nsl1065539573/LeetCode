package main

func main() {

}

func invertTree(root *TreeNode) *TreeNode {
	postorder(root)
	return root
}

func postorder(root *TreeNode) {
	if root == nil {
		return
	}
	postorder(root.Left)
	postorder(root.Right)
	temp := root.Left
	root.Left = root.Right
	root.Right = temp
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
