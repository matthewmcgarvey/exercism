
fun reverse(str: String): String =
    str.foldRight(StringBuilder(), { curr, acc -> acc.append(curr)})
        .toString()
