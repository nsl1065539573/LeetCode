package main

import "fmt"

func main() {
	arr := []int{1, 2, 3, 4, 5, 6, 7}
	quickSort(arr, 0, len(arr)-1)
	fmt.Println(arr)
}

func quickSort(arr []int, l, r int) {
	if l < r {
		i := l
		j := r
		X := arr[l]
		for i < j {
			for arr[j] >= X && i < j {
				j--
			}
			arr[i] = arr[j]
			for arr[i] < X && i < j {
				i++
			}
			arr[j] = arr[i]
		}
		arr[i] = X
		quickSort(arr, l, i-1)
		quickSort(arr, i+1, r)
	}
}
