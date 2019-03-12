package raindrops

import (
	"strconv"
)

type factorToSound struct {
	factor int
	sound  string
}

var factorsToSounds = [3]factorToSound{
	factorToSound{3, "Pling"},
	factorToSound{5, "Plang"},
	factorToSound{7, "Plong"}}

// Convert turns numbers into raindrops
func Convert(num int) string {
	sound := ""
	for _, fts := range factorsToSounds {
		if num%fts.factor == 0 {
			sound += fts.sound
		}
	}
	if sound != "" {
		return sound
	}
	return strconv.Itoa(num)
}
