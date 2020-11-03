package num283

func moveZeroes(numbers []int)  {
	var index int = 0
	for i := 0; i < len(numbers); i++ {
		if (numbers[i] != 0) {
			numbers[index] = numbers[i]
			index++
		}
	}
	for i := index; i < len(numbers); i++ {
		numbers[i] = 0
	}
}
