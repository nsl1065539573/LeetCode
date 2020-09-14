package main

import "fmt"

type Names struct {
	Name string
}

func main() {
	ints := make([]int, 0)
	fmt.Printf("what is ints: %p\n", ints)
	recursion(ints, 0)
	// ints := make([]int, 0)
	// for i := 0; i < 10; i++ {
	// 	ints = append(ints, i)
	// 	fmt.Printf("&slice:%p\n", &ints)
	// 	fmt.Printf("slice:%p\n", &ints)
	// }
}

func recursion(ints []int, i int) {
	if i == 10 {
		return
	}
	fmt.Printf("what is ints: %p\t", ints)
	ints = append(ints, i)
	fmt.Printf("address %p\n", ints)
	recursion(ints, i+1)
}
