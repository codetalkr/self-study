package example.introduction

import org.assertj.core.api.BDDAssertions.*
import org.junit.jupiter.api.Test

class NullSafetyTest {

    @Test
    @SuppressWarnings
    fun `Null Safety`() {
        var neverNull: String = "This can't be null"

//        neverNull = null //Null can not be a value of a non-null type String

        var nullable: String? = "You can keep a null here"

        nullable = null

        var inferredNonNull = "The compiler assumes non-null"

//        inferredNonNull = null // compile error

        fun strLength(notNull: String): Int {
            return notNull.length
        }

        then(strLength(neverNull)).isEqualTo(18)
//        then(strLength(nullable)).isEqualTo(0) // compile error

        // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/plus.html
        then(nullable.plus(" test")).isEqualTo("null test")

        thenThrownBy {
            nullable!!.length
        }.isExactlyInstanceOf(KotlinNullPointerException::class.java)

    }

    @Test
    fun `Working with Nulls`() {
        fun describeString(maybeString: String?): String =
                if (maybeString != null && maybeString.isNotEmpty())
                    "String of length ${maybeString.length}"
                else
                    "Empty or null string"


        then(describeString("string"))
                .isEqualTo("String of length 6")

        then(describeString(null))
                .isEqualTo("Empty or null string")

        then(describeString(""))
                .isEqualTo("Empty or null string")
    }
}