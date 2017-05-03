package aoeiuv020

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class BasicSyntaxTest {
    @Test
    fun readOnly() {
        val r = 0
        // r = 1 // Val cannot be reassigned
        assertEquals(0, r)
        var v = 1
        assertEquals(1, v)
        v = 2
        assertEquals(2, v)
    }

    @Suppress("unused")
    fun comment() {
        /* block comment 
        /* inner block comment */
        fail()
        */
        // fail()
    }

    @Test
    fun number() {
        var i = 0xff_ee_dd
        assertEquals(0xffeedd, i)
        i = 0b0110_1100
        assertEquals(0x6c, i)
    }

    @Test
    fun assert() {
        assert(true)
    }

    @Test
    fun function() {
        fun sumA(a: Int, b: Int): Int = a + b
        assertEquals(3, sumA(1, 2))
        fun sumB(a: Int, b: Int) = a + b
        assertEquals(3, sumB(1, 2))
        fun sumC(a: Int, b: Int): Unit {}
        assertEquals(Unit.javaClass, sumC(1, 2).javaClass)
        //下面这个抛空指针异常且无法捕获，怀疑是kotlinc的bug,
        //bug reported kotlin-1.1.2: https://youtrack.jetbrains.com/issue/KT-17692
        //assertEquals(Unit.javaClass, sumC(1, 2)::class.java) // org.jetbrains.kotlin.codegen.CompilationException: Back-end (JVM) Internal error: Failed to generate function function Cause: java.lang.NullPointerException 
    }

    @Test
    fun lateinitTest() {

    }

    @Test
    fun isTest() {
        fun getObejct(): Any = "any"
        val any: Any = getObejct()
        assertEquals(String::class.java, any::class.java)
        // e: Type inference failed. The value of the type parameter T should be mentioned in input types (argument types, receiver type or expected type). Try to specify it explicitly.
        //assertEquals(String::class.java, any.javaClass)
        //assertEquals(3, any.length) // e: Unresolved reference: length
        if (any is String) {
            assertEquals(3, any.length)
        }
        //assertEquals(3, any.length) // e: Unresolved reference: length
        if (any !is String) {
            fail()
            return
        }
        assertEquals(3, any.length)
    }
}
