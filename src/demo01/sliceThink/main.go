package main

import "fmt"

func main() {
	arr := []int{1, 2, 3}
	recursion(arr, 0)
	fmt.Println("main print:", arr)
}

func recursion(arr []int, i int) {
	if i < 10 {
		arr = append(arr, i)
		fmt.Println("recursion print:", arr)
		recursion(arr, i+1)
	}
}
