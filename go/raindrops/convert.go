package raindrops

import (
	"strconv"
)

var factorsToSounds = map[int]string{
	3: "Pling",
	5: "Plang",
	7: "Plong",
}

// Convert turns numbers into raindrops
func Convert(num int) string {
	sound := ""
	for factor, s := range factorsToSounds {
		if num%factor == 0 {
			sound = sound + s
		}
	}
	if sound != "" {
		return sound
	}
	return strconv.Itoa(num)
}
