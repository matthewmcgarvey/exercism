class PhoneNumber(private val _number: String) {
    val number: String?
        get() {
            var cleaned = _number.filter(Char::isDigit)
            if (cleaned.startsWith("1")) {
                cleaned = cleaned.substring(1)
            }

            if (cleaned.length != 10) {
                return null
            }

            val areaCode = cleaned.substring(0, 3)
            val exchangeCode = cleaned.substring(3, 6)

            if (areaCode.startsWith("1") || areaCode.startsWith("0")) {
                return null
            }

            if (exchangeCode.startsWith("0") || exchangeCode.startsWith("1")) {
                return null
            }

            return cleaned
        }
}