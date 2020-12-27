package num941

import "fmt"

func validMountainArray(A []int) bool {
	var up bool = true
	for i := 1; i < len(A); i++ {
		if up {
			fmt.Printf("up is true, i = %v \n", i)
			if A[i] < A[i-1] {
				fmt.Printf("up is true & A[i] < A[i-1], i = %v \n", i)
				if i == 1 {
					return false
				}
				up = false
			}
			if A[i] == A[i-1] {
				return false
			}
		} else {
			fmt.Printf("up is false, i = %v \n", i)
			if A[i] >= A[i-1] {
				return false
			}
		}
	}
	if up {
		fmt.Printf("up is true return fasle\n")
		return false
	}
	return true
}
