package num117

type Node struct {
	Val int
	Left *Node
	Right *Node
	Next *Node
}

/**
递归尝试了 没法做。 层序吧
 */
func connect(root *Node) *Node {
	if root == nil {
		return nil
	}
	list := make([]*Node, 0)
	cur := 1
	list = append(list, root)
	for len(list) > 0 {
		for i := 0; i < cur; i++ {
			node := list[i]
			list = list[: len(list) - 1]
			if node.Left != nil {
				list = append(list, node.Left)
			}
			if node.Right != nil {
				list = append(list, node.Right)
			}
		}
		for i := 0; i < len(list) - 1; i++ {
			list[i].Next = list[i + 1]
		}
		cur = len(list)
	}
	return root
}

func domain(left *Node, right *Node) {
	if left == nil || right == nil {
		return
	}
	left.Next = right
	domain(left.Left, left.Right)
	if left.Right == nil {
		if right.Left != nil {
			domain(left.Left, right.Left)
		} else {
			domain(left.Left, right.Right)
		}
	}else {
		if right.Left != nil {
			domain(left.Right, right.Left)
		} else {
			domain(left.Right, right.Right)
		}
	}
	domain(right.Left, right.Right)
}