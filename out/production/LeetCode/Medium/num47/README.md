# 题目描述
给定一个可包含重复数字的序列，返回所有不重复的全排列。

**示例:**

>输入: [1,1,2]
>输出:
>[
>  [1,1,2],
>  [1,2,1],
>  [2,1,1]
> ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
## 决策树如下
```
           根
       /   |   \
      1    1    2
     / \  / \   / \
    1   2 1  2 1   1
    |   | |  | |   |
    2   1 2  1 1   1
```
回溯算法中我们需要遍历选择列表，选择列表就是每个父节点的所有子节点：
根节点的选择列表是 1  1  2， 1 的选择列表是 1 2   2 的选择列表是1  1
我们可以看到，让我们对第一个1排序完后，对第二个1再排序就会重复
**解决办法：**
在同一个for循环中，如果该值已经被访问过，那么就不再访问此节点，如在第一次循环时，如果`1`这个值已经被排序，那么就不再访问所有的`1`值。

### 代码：
```go
func permuteUnique(nums []int) [][]int {
	res := make([][]int, 0)
	backTrackv2(0, nums, &res)
	return res
}

func backTrackv2(begin int, nums []int, res *[][]int) {
	if begin == len(nums)-1 {
		temp := make([]int, len(nums))
		copy(temp, nums)
		*res = append(*res, temp)
		return
	}
    visited := make(map[int]bool)
	for i := begin; i < len(nums); i++ {
		if visited[nums[i]] {
			continue
		}
		nums[i], nums[begin] = nums[begin], nums[i]
		backTrackv2(begin+1, nums, res)
		nums[i], nums[begin] = nums[begin], nums[i]
        visited[nums[i]] = true
	}
}
```