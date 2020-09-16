package num116

func connect(root *Node) *Node {
	if root == nil {
		return root
	}
	domain(root.Left, root.Right)
	return root
}

func domain(left, right *Node) {
	if left == nil || right == nil {
		return
	}
	left.Next = right
	domain(left.Left, left.Right)
	domain(right.Left, right.Right)
	domain(left.Right, right.Left)
}

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}
