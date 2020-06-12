package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Print(twoSum([]int{1, 2, 3, 4}, 6))
}

func twoSum(arr []int, target int) []int {
	sort.Ints(arr)
	left := 0
	right := len(arr) - 1

	for left < right {
		currentSum := arr[left] + arr[right]
		if currentSum == target {
			return []int{arr[left], arr[right]}
		} else if currentSum < target {
			left++
		} else {
			right--
		}
	}
	return []int{0, 0}
}
