package num147

type ListNode struct {
	Val  int
	Next *ListNode
}

func insertionSortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	insertionSortList(head.Next)
	insertValue := head.Val
	temp := head
	for temp.Next != nil && temp.Next.Val < insertValue {
		temp.Val = temp.Next.Val
		temp = temp.Next
	}
	temp.Val = insertValue
	return head
}
