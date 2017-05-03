package aoeiuv020

import org.junit.Test
import kotlin.test.assertEquals

class TypeTest {
    @Suppress("JAVA_CLASS_ON_COMPANION", "RemoveSingleExpressionStringTemplate")
    @Test
    fun type() {
        val i = 0
        assertEquals("int (Kotlin reflection is not available)", "${i::class}")
        assertEquals("int", "${i::class.java}")
        //w: The resulting type of this 'javaClass' call is Class<Int.Companion> and not Class<Int>. Please use the more clear '::class.java' syntax to avoid confusion
        assertEquals("${i::class.java}", "${i.javaClass}")
        val ii: Int = 0
        assertEquals("${i::class}", "${ii::class}")
        assertEquals("int", "${ii::class.java}")
        assertEquals("${i::class}", "${Int::class}")
        assertEquals("${i::class.java}", "${Int::class.java}")
        assertEquals("kotlin.jvm.internal.IntCompanionObject", "${Int.javaClass.name}")
        assertEquals("${Int.javaClass.name}", Int.javaClass.name)
        assertEquals("class kotlin.jvm.internal.IntCompanionObject", "${Int.javaClass}")
        assertEquals("${Int.javaClass}", Int.javaClass.toString())
        assertEquals("class java.lang.Class", "${Int::class.java.javaClass}")
        assertEquals("${Int::class.java.javaClass} (Kotlin reflection is not available)", "${Int.javaClass::class}")
        assertEquals("${Int::class.java.javaClass}", "${Int.javaClass::class.java}")
        assertEquals(Int.javaClass.javaClass, Int.javaClass::class.java)
        assertEquals("int", "${Int::class.javaPrimitiveType}")
        assertEquals("Integer", Int::class.javaObjectType.simpleName)
    }

    @Test
    fun to() {
        val i = 0
        assertEquals("int", "${i::class.java}")
        val l = 0L + i
        assertEquals("long", "${l::class.java}")
        val ll = i.toLong()
        assertEquals("long", "${ll::class.java}")
    }

    @Test
    fun character() {
        val s = "string"
        //assertEquals('s', s.charAt(0)) // Unresolved reference: charAt
        val charAtMethod = s.javaClass.getMethod("charAt", Int::class.java)
        assertEquals('s', charAtMethod.invoke(s, 0))
        assertEquals('s', s[0])
        val c = '0'
        assertEquals("char", "${c::class.java}")
        assertEquals(48, c.toInt())
        //assertEquals(48, c) // Type inference failed: Cannot infer type parameter T in fun <T> assertEquals(expected: T, actual: T, message: String? = ...): Unit
        //assertEquals(48, 0 + c) // None of the following functions can be called with the arguments supplied: 
        //assertEquals(48, c as Int) // java.lang.Character cannot be cast to java.lang.Integer
        // if (c == 48) fail() // Operator '==' cannot be applied to 'Char' and 'Int'
    }

    @Test
    fun boolean() {
        val b = true
        assertEquals("boolean", "${b::class.java}")
        assertEquals("true", "$b")
    }

    @Test
    fun string() {
        var i = 0
        var s = "a$i"
        assertEquals("a0", s)
        i = 1
        assertEquals("a0", s)
        s = "b${++i}"
        assertEquals("b2", s)
        assertEquals(2, i)
        s = "$s.length"
        assertEquals("b2.length", s)
        s = "$i++"
        assertEquals("2++", s)
        assertEquals(2, i)
        s = "$++i"
        assertEquals("\$++i", s)
        s = "\$i"
        assertEquals("\$i", s)
        s = "${s.length}"
        assertEquals("2", s)
        s = "str"
        i = 0
        for (c in s) {
            //c = 'a' // Val cannot be reassigned
            assertEquals(s[i++], c)
        }
        s =  """
        hello
        """
        assertEquals("\n        hello\n        ", s)
        assertEquals("hello", s.trim())
        s = """
        |first
        |second
        """.trimMargin()
        assertEquals("first\nsecond", s)
        s = """
        >>first
        >>second
        """.trimMargin(">>")
        assertEquals("first\nsecond", s)
    }

    @Test
    fun any() {
        fun getObject(): Any = "any"
        assertEquals(String::class.java, getObject()::class.java)
        assertEquals(getObject()::class.java, getObject().javaClass)
        //e: Type inference failed. The value of the type parameter T should be mentioned in input types (argument types, receiver type or expected type). Try to specify it explicitly.
        //assertEquals(Object::class.java, Any::class.java)
        assertEquals(Object::class.java.name, Any::class.java.name)
        assertEquals("${Object::class.java}", "${Any::class.java}")
    }
}
