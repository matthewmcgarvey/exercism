package scrabble

import (
	"strings"
)

var values = map[string]int{
	"AEIOULNRST": 1,
	"DG":         2,
	"BCMP":       3,
	"FHVWY":      4,
	"K":          5,
	"JX":         8,
	"QZ":         10}

// Score determines the scrabble score
// of a given string
func Score(input string) int {
	score := 0
	for _, letter := range strings.ToUpper(input) {
		score += getScore(letter)
	}
	return score
}

func getScore(input rune) int {
	for chars, score := range values {
		if contains(chars, input) {
			return score
		}
	}
	return 0
}

func contains(s string, e rune) bool {
	for _, a := range s {
		if a == e {
			return true
		}
	}
	return false
}
