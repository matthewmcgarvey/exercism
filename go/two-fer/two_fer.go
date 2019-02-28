package twofer

func ShareWith(name string) string {
	var actual string
	if len(name) == 0 {
		actual = "you"
	} else {
		actual = name
	}
	return "One for " + actual + ", one for me."
}
