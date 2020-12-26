package num215

func findKthLargest(nums []int, k int) int {
	h := make(myHeap, k)
	for i := 0; i < len(nums); i++ {
		h.Push(nums[i])
	}
	return h.Pop().(int)
}

type myHeap []int

func (h myHeap) Len() int {
	return len(h)
}

func (h myHeap) Less(i, j int) bool { return h[i] < h[j] } // 这里决定 大小顶堆 现在是小顶堆

func (h myHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *myHeap) Pop() interface{} {
	old := *h
	n := len(old)

	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func (h *myHeap) Push(x interface{}) { // 绑定push方法，插入新元素
	*h = append(*h, x.(int))
}
