package twofer

// ShareWith determines who to share with
// defaults to "you"
func ShareWith(name string) string {
	if len(name) == 0 {
		name = "you"
	}
	return "One for " + name + ", one for me."
}
