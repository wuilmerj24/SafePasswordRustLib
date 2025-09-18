package upinn.tech.safepasswordlib


open class SafePassword {
    open fun makePassword(
        length: Int,
        includeUppercase: Boolean,
        includeNumbers: Boolean,
        includeSymbols: Boolean
    ): String{
        val password= generatePassword(length.toString().toULong(),includeUppercase,includeNumbers,includeSymbols)
        return password
    }

    open fun checkPassword(password:String): PasswordStrength{
        return checkStrength(password)
    }
}