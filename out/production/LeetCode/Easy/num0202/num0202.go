package num0202

type ListNode struct {
	Val  int
	Next *ListNode
}

func kthToLast(head *ListNode, k int) int {
	var fast *ListNode = head
	for i := 0; i < k; i++ {
		fast = fast.Next
	}
	var slow *ListNode = head
	for fast != nil {
		slow = slow.Next
		fast = fast.Next
	}
	return slow.Val
}
