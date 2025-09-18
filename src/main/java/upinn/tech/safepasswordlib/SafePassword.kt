package upinn.tech.safepasswordlib

import android.util.Log

open class SafePassword {
    open fun makePassword(
        length: Int,
        includeUppercase: Boolean,
        includeNumbers: Boolean,
        includeSymbols: Boolean
    ): String{
        Log.d("makePassword params",length.toString())
        Log.d("includeUppercase params",includeUppercase.toString());
        Log.d("includeNumbers params",includeNumbers.toString());
        Log.d("includeSymbols params",includeSymbols.toString());

        val password= generatePassword(length.toString().toULong(),includeUppercase,includeNumbers,includeSymbols)
        Log.d("password ",password)
        return password
    }

    open fun checkPassword(password:String): PasswordStrength{
        return checkStrength(password)
    }
}