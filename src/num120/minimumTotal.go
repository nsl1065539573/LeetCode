package main

import "fmt"

func main() {
	var nums [][]int = [][]int{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}}
	fmt.Println(minimumTotalv2(nums))
}

// v2版本，优化空间
func minimumTotalv2(triangle [][]int) int {
	var length int = len(triangle)
	for i := length - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			minValue := min(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j]
			fmt.Printf("[%v, %v] = %v", i, j, minValue)
			triangle[i][j] = minValue
		}
		fmt.Println()
	}
	return triangle[0][0]
}

// v1版本，不再使用append，在创建后给dp Table 赋长度
func minimumTotalv1(triangle [][]int) int {
	var length int = len(triangle)
	minSum := make([][]int, length)
	for i := 0; i < length; i++ {
		minSum[i] = make([]int, len(triangle[i]))
	}
	for i := 0; i < len(triangle); i++ {
		minSum[length-1][i] = triangle[length-1][i]
	}
	for i := length - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			minValue := min(minSum[i+1][j], minSum[i+1][j+1]) + triangle[i][j]
			fmt.Printf("[%v, %v] = %v", i, j, minValue)
			minSum[i][j] = minValue
		}
		fmt.Println()
	}
	return minSum[0][0]
}

// v0版本，先AC，再优化
func minimumTotalv0(triangle [][]int) int {
	var length int = len(triangle)
	minSum := make([][]int, length)
	for i := 0; i < length; i++ {
		minSum[i] = make([]int, len(triangle[i]))
	}
	for i := 0; i < len(triangle); i++ {
		minSum[length-1][i] = triangle[length-1][i]
	}
	for i := length - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			minValue := min(minSum[i+1][j], minSum[i+1][j+1]) + triangle[i][j]
			fmt.Printf("[%v, %v] = %v", i, j, minValue)
			minSum[i][j] = minValue
		}
		fmt.Println()
	}
	return minSum[0][0]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
