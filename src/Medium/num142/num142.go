package num142

type ListNode struct {
	Val int
	Next *ListNode
}

func detectCycle(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	fast, slow := head, head
	arr := make(map[*ListNode]interface{}, 0)
	for fast.Next != nil && fast.Next.Next != nil {
		arr[slow] = nil
		slow = slow.Next;
		fast = fast.Next.Next;
		if _, ok := arr[slow]; ok {
			return slow
		}
	}
	return nil
}
