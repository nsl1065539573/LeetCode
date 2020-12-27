package num328

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func oddEvenList(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	head1 := head
	head2 := head1.Next
	temp := head2
	for head1.Next != nil && head1.Next.Next != nil {
		head1.Next = head1.Next.Next
		head1 = head1.Next
		head2.Next = head1.Next
		if head2.Next != nil {
			head2 = head2.Next
		}
	}
	fmt.Printf("head1 is %v \n", head1)
	fmt.Printf("head2 is %v \n", head2)
	head1.Next = temp
	return head
}
