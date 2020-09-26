# LeetCode 94
给定一个二叉树，返回它的中序 遍历。

示例:

```
输入: [1,null,2,3]
   1
    \
     2
    /
   3
```

```输出: [1,3,2]```

## 思路分析
中序遍历的顺序为  左 --> 根 --> 右，采用迭代的方式，我们使用栈来模拟递归
递归的顺序应该为:
```go
    func inOder(root *TreeNode) {
        if (root == nil) {
            return
        }
        // 左
        inOrder(root.Left)
        // 根
        fmt.Println(root.Val)
        // 右
        inOrder(root.Right)
    }
```
步骤如下：
1. 所以我们可以将当前节点的左侧节点添加进栈（即：root.Left）
2. 在全部添加进去后，栈顶元素就应该是中序遍历的第一个节点，即树的最左下的左子节点。
3. 再将该左子节点的右子节点添加进栈
4. 重复第一步，直到栈为空并且当前节点为空，即是将整棵树遍历完

代码：
```go
func inorderTraversal(root *TreeNode) []int {
    stack := list.New()
    res := make([]int, 0)
    curr := root
    for {
        if stack.Len() == 0 && curr == nil {
            break
        }
        for {
            if curr == nil {
                break
            }
            stack.PushBack(curr)
            curr = curr.Left
        }
        curr = stack.Remove(stack.Back()).(*TreeNode)
        res = append(res, curr.Val)
        curr = curr.Right
    }
    return res
}
```