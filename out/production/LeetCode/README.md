# Go
## 递归调用切片的坑
力扣刷题回溯算法时，经常需要返回路径，即多维切片。
在递归调用过程中，我们将一维切片添加到结果集中后，打印输出发现为空：
```go
func main() {
	res := combine(4, 2)
	fmt.Println("res:", res)
}

func combine(n int, k int) [][]int {
	res := make([][]int, 0)
	track := make([]int, 0)
	// backTrack(&res, &track, n, k, 1)
	backTrackNoPoint(res, track, n, k, 1)
	return res
}
func backTrackNoPoint(res [][]int, track []int, n, k, begin int) {
	cur := make([]int, len(track))
	copy(cur, track)
	fmt.Println(cur)
	if len(track) == k {
		res = append(res, cur)
		return
	}
	for i := begin; i <= n; i++ {
		track = append(track, i)
		backTrackNoPoint(res, track, n, k, i+1)
		track = cur[:len(cur)]
	}
}
```
执行结果如下：
```go
[]
[1]
[1 2]
[1 3]
[1 4]
[2]
[2 3]
[2 4]
[3]
[3 4]
[4]
res: []
```
我们发现res中并没有值。
另一个测试如下：
```go
package main

import "fmt"

type Names struct {
	Name string
}

func main() {
	mynames := make([]*Names, 0)
	recursion(mynames, 0)
}

func recursion(mynames []*Names, i int) {
	if i == 10 {
		return
	}
	my := &Names{
		Name: "append"}
	mynames = append(mynames, my)
	fmt.Printf("address %p\n", &mynames)
	recursion(mynames, i+1)
}
```
输出如下：
```go
what is mynames: 0x5a6d88       address 0xc000006030
what is mynames: 0xc000006030   address 0xc000046210
what is mynames: 0xc000046210   address 0xc000004560
what is mynames: 0xc000004560   address 0xc000004560
what is mynames: 0xc000004560   address 0xc000050040
what is mynames: 0xc000050040   address 0xc000050040
what is mynames: 0xc000050040   address 0xc000050040
what is mynames: 0xc000050040   address 0xc000050040
what is mynames: 0xc000050040   address 0xc00010e000
what is mynames: 0xc00010e000   address 0xc00010e000
```

## 结论
go语言中切片传递是值传递
将切片拷贝一份传给了函数，拷贝和原切片持有一个共同的底层数组
当函数内涉及到切片扩容时，函数内的拷贝底层指向了另一个数组，所以此时函数内的改变不会影响到外部。

https://blog.csdn.net/LYue123/article/details/88363685

# 算法
## 广度优先
广度优先是指将当前层的所有节点的所有子节点或邻接顶点全部搜索一遍，然后进入下一层，执行与上一层一样的操作，搜索所有子节点或邻接节点。

算法框架如下：
```go
func BFS(root *TreeNode) {
	if root == nil {
		return
	}
	list := []*TreeNode{}
	list = append(list, root) 
	for len(list) > 0 {
		cur := len(list)
		for i := 0; i < cur; i++ {
			temp := list[0]
			list = list[1:]
			for 节点 in 子节点列表 {
				list = append(list, 子节点)
			}
		}
	}
}
```
如上我们可以遍历到一棵二叉树的所有节点，之后就可以很方便的进行操作

BFS算法完整版框架:
```
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里 */
        step++;
    }
}
```
>队列 q 就不说了，BFS 的核心数据结构；cur.adj() 泛指 cur 相邻的节点，比如说二维数组中，cur 上下左右四面的位置就是相邻节点；visited 的主要作用是防止走回头路，大部分时候都是必须的，但是像一般的二叉树结构，没有子节点到父节点的指针，不会走回头路就不需要 visited。

--------------------------------------------------------------------------------
完整版框架摘自labuladong的算法小抄：https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/bfs-kuang-jia