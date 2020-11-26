package num452

func findMinArrowShots(points [][]int) int {
	if len(points) == 0 {
		return 0
	}
	if len(points) == 1 {
		return 1
	}
	quickSort(points, 0, len(points)-1)
	target := points[0]
	res := 1
	for i := 1; i < len(points); i++ {
		if points[i][0] > target[1] {
			target = points[i]
			res += 1
		}
	}
	return res
}

func quickSort(arr [][]int, l, r int) {
	if l < r {
		X := arr[l]
		i := l
		j := r
		for i < j {
			for i < j && X[0] >= arr[j][0] {
				j--
			}
			arr[i] = arr[j]
			i++
			for i < j && X[0] < arr[i][0] {
				i++
			}
			arr[j] = arr[i]
			j--
		}
		arr[i] = X
		quickSort(arr, l, i-1)
		quickSort(arr, i+1, r)
	}
}
