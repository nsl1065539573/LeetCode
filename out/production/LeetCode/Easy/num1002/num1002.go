package num1002

import "math"

func commonChars(A []string) []string {
	
	minTimes := make([]int, 26)
	for i := 0; i < 26; i++ {
		minTimes[i] = math.MaxInt64
	}
	for _, word := range A {
		record := make([]int, 26)
		for i := 0; i < len(word); i++ {
			record[word[i] - 'a']++
		}
		for i := 0; i < 26; i++ {
			if minTimes[i] > record[i] {
				minTimes[i] = record[i]
			}
		}
	}
	res := make([]string, 0)
	for i := 0; i < len(minTimes); i ++ {
		if (minTimes[i] > 0 && minTimes[i] < math.MaxInt64) {
			for j := 0; j < minTimes[i]; j++ {
				res = append(res, string(i + 'a'))
			}
		}
	}
	return res
}