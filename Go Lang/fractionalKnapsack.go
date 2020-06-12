package main

import (
	"fmt"
	"strconv"
)

func main() {
	fKnap([]int{18, 5, 9, 10, 12, 17}, []int{7, 2, 3, 5, 3, 2}, 13)

	//	Item            Profit          Weight          P/W
	//	1               17              2               8.50
	//	2               12              3               4.00
	//	3               9               3               3.00
	//	4               18              7               2.57
	//	5               5               2               2.50
	//	6               10              5               2.00
	//	Total Profit:  50.86
	//	Total Weight:  13
	//	Fraction of Items Taken:  [1 1 1 0.71 0 0]

}

func fKnap(profits, weights []int, sackCapacity int) {
	if len(profits) != len(weights) {
		return
	}

	var N = len(profits)
	var CW, CP float64 = 0, 0

	X := make([]float64, N)
	pbw := make([]float64, N)

	for i := 0; i < N; i++ {
		pbw[i] = roundOff(float64(profits[i]) / float64(weights[i]))
	}

	var sorted = customSort(profits, weights, sort(pbw))

	profits = sorted[0]
	weights = sorted[1]

	fmt.Printf("Item\t\tProfit\t\tWeight\t\tP/W\n")

	for i := 0; i < N; i++ {
		if CW+float64(weights[i]) < float64(sackCapacity) {
			X[i] = 1
			CP += float64(profits[i])
			CW += float64(weights[i])
		} else {
			X[i] = (float64(sackCapacity) - CW) / float64(weights[i])
			CP += float64(profits[i]) * X[i]
			X[i] = roundOff(X[i])
			CW = float64(sackCapacity)
		}

		fmt.Printf("%d\t\t%d\t\t%d\t\t%.2f\n", i+1, profits[i], weights[i], roundOff(pbw[i]))
	}

	fmt.Println("Total Profit: ", roundOff(CP))
	fmt.Println("Total Weight: ", roundOff(CW))
	fmt.Println("Fraction of Items Taken: ", X)
}

func customSort(profits, weights []int, pbw []float64) [][]int {
	var N = len(profits)
	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			if pbw[i] == roundOff(float64(profits[j])/float64(weights[j])) {
				swapI(i, j, profits)
				swapI(i, j, weights)
			}
		}
	}
	return [][]int{profits, weights}
}

func sort(arr []float64) []float64 {
	isSorted := false
	counter := 0

	for !isSorted {
		isSorted = true
		for i := 0; i < len(arr)-1-counter; i++ {
			if arr[i] < arr[i+1] {
				swapF(i, i+1, arr)
				isSorted = false
			}
		}
		counter++
	}
	return arr
}

func swapI(i, j int, arr []int) {
	arr[i], arr[j] = arr[j], arr[i]
}

func swapF(i, j int, arr []float64) {
	arr[i], arr[j] = arr[j], arr[i]
}

func roundOff(x float64) float64 {
	if s, err := strconv.ParseFloat(fmt.Sprintf("%.2f", x), 64); err == nil {
		return s
	} else {
		return 0
	}
}
