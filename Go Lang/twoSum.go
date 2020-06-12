package main

import (
	"fmt"
	"sort"
)

	func main() {
		twoSum([]int{1, 2, 3, 4}, 6)
	}

	func twoSum(arr []int, target int) {
		sort.Ints(arr)
		left := 0
		right := len(arr) - 1

		for left < right {
			currentSum := arr[left] + arr[right]
			if currentSum == target {
				fmt.Printf("[%d , %d]", arr[left], arr[right])
				return
			} else if currentSum < target {
				left++
			} else {
				right--
			}
		}
	}

