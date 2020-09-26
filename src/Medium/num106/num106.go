package num106

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	if len(inorder) == 0 || len(postorder) == 0 {
		return nil
	}
	indexMap := make(map[int]int)
	for i := 0; i < len(inorder); i++ {
		indexMap[inorder[i]] = i
	}
	var build func(int, int) *TreeNode
	rootIndex := len(postorder) - 1
	build = func(leftIndex, rightIndex int) *TreeNode {
		if leftIndex > rightIndex || rootIndex < 0 {
			return nil
		}
		root := &TreeNode{postorder[rootIndex], nil, nil}
		index := indexMap[postorder[rootIndex]]
		rootIndex -= 1
		root.Right = build(index+1, rightIndex)
		root.Left = build(leftIndex, index-1)
		return root
	}
	return build(0, len(inorder)-1)
}
