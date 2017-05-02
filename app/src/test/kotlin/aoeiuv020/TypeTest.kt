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
}
