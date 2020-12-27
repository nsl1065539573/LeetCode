package num222

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func countNodes(root *TreeNode) int {
	// if root == nil {
	// 	return 0
	// }
	// stack := make([]*TreeNode, 0)
	// res := 0
	// stack = append(stack, root)
	// for len(stack) > 0 {
	// 	root := stack[0]
	// 	stack = stack[1:]
	// 	res++
	// 	if root.Left != nil {
	// 		stack = append(stack, root.Left)
	// 	}
	// 	if root.Right != nil {
	// 		stack = append(stack, root.Right)
	// 	}
	// }
	res := 0
	preOrder(root, &res)
	return res
}

func preOrder(root *TreeNode, res *int) {
	if root == nil {
		return
	}
	*res += 1
	preOrder(root.Left, res)
	preOrder(root.Right, res)
}
