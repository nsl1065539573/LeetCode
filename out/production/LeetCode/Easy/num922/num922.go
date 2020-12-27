package num922

func sortArrayByParityII(A []int) []int {
	i := 0
	j := 1
	for i < len(A) && j < len(A) {
		if A[i]%2 != 0 && A[j]%2 != 1 {
			temp := A[i]
			A[i] = A[j]
			A[j] = temp
			i += 2
			j += 2
			continue
		}
		if A[i]%2 != 0 {
			j += 2
			continue
		}
		if A[j]%2 != 1 {
			i += 2
			continue
		}
		i += 2
		j += 2
	}
	return A
}
