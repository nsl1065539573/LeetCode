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