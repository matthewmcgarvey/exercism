object PigLatin {
    fun translate(input: String): String =
        when {
            input.contains(" ") -> input.split(" ").map(::translate).joinToString(" ")
            input[0] in listOf('a', 'e', 'i', 'o', 'u') -> input + "ay"
            listOf("yt", "xr").any{input.startsWith(it)} -> input + "ay"
            listOf("squ", "thr", "sch").any{input.startsWith(it)} -> input.substring(3) + input.substring(0, 3) + "ay"
            listOf("ch", "th", "qu", "rh").any{input.startsWith(it)} -> input.substring(2) + input.substring(0, 2) + "ay"
            else -> input.substring(1) + input[0] + "ay"
        }
}