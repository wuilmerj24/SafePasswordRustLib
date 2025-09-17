package upinn.tech.safepasswordlib


class SafePassword {
    open fun gPassword(
        length: ULong,
        includeUppercase: Boolean,
        includeNumbers: Boolean,
        includeSymbols: Boolean,
    ): String{
        return generatePassword(length,includeUppercase,includeNumbers,includeSymbols)
    }

    open fun cPassword(password:String): PasswordStrength{
        return checkStrength(password)
    }
}