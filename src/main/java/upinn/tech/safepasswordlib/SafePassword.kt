package upinn.tech.safepasswordlib


open class SafePassword {
    open fun makePassword(
        length: ULong,
        includeUppercase: Boolean,
        includeNumbers: Boolean,
        includeSymbols: Boolean
    ): String{
        val password= generatePassword(length,includeUppercase,includeNumbers,includeSymbols)
        return password
    }

    open fun checkPassword(password:String): PasswordStrength{
        return checkStrength(password)
    }
}