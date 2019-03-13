package raindrops

import (
	"strconv"
)

// Convert turns numbers into raindrops
func Convert(num int) string {
	return defaultIfBlank(
		ifZero(num%3, "Pling")+ifZero(num%5, "Plang")+ifZero(num%7, "Plong"),
		strconv.Itoa(num))
}

func ifZero(mod int, result string) string {
	if mod == 0 {
		return result
	}
	return ""
}

func defaultIfBlank(strToTest string, defaultStr string) string {
	if strToTest == "" {
		return defaultStr
	}
	return strToTest
}
