package num637

 //Definition for a binary tree node.
 type TreeNode struct {
      Val int
      Left *TreeNode
     Right *TreeNode
 }
 
 // 层序遍历
 func averageOfLevels(root *TreeNode) []float64 {
    var list []*TreeNode
    var res []float64
    list = append(list, root)
    cur := 1
    for len(list) > 0 {
        sum := 0
        for i := 0; i < cur; i++ {
            sum += list[i].Val
            if list[i].Left != nil {
                list = append(list, list[i].Left)
            }
            if list[i].Right != nil {
                list = append(list, list[i].Right)
            }
        }
        var avg float64 = float64(sum) / float64(cur)
        res = append(res, avg)
        list = list[cur:]
        cur = len(list)
    }
    return res
}