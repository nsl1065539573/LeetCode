# 题目描述
翻转一棵二叉树。

示例：

输入：

>     4
>   /   \
>  2     7
> / \   / \
>1   3 6   9

输出：

>     4
>   /   \
>  7     2
> / \   / \
>9   6 3   1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
### 解题思路
由题意知，我们需要反转每一个节点的左右子节点，很容易想到从下往上翻转，这样到根节点后，只需要将左右子节点翻转，即可达到翻转整棵树的目的。
后序遍历的顺序是 左 --> 右 --> 根  正好符合我们的目的，因为我们总要先找到最下面的，所以采用后序的顺序，在到最下节点时，再进行子节点对换操作

### 代码

```golang
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 // 后序遍历  左右根 在根节点处进行左子树和右子树互换
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

```

最后一个小玩笑：至少在翻转二叉树方面，我们强过了Max Howell 