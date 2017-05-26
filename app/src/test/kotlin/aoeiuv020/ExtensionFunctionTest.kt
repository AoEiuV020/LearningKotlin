package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class ExtensionFunctionTest {
    @Test
    fun add() {
        fun Int.isPositive(): Boolean = this > 0
        assertTrue(8.isPositive())
        //不行，kotlin的反射还不完善，下面两句在kotlinc命令行正确，
        //assertEquals(0, Int::class.declaredMemberExtensionFunctions.size)
        //assertEquals(0, Int.javaClass.kotlin.memberExtensionFunctions.size)
    }

    @Test
    fun nullableReceiver() {
        fun Any?.toString(): String {
            return if (this == null) "null" else "notnull"
        }
        assertEquals("null", null.toString())
        //没有调用上面那个拓展方法，
        assertEquals("8", 8.toString())
        fun Any?.ts(): String {
            return if (this == null) "null" else "notnull"
        }
        assertEquals("null", null.ts())
        assertEquals("notnull", 8.ts())
    }

    @Test
    fun property() {
        assertEquals(2, 1.a)
        assertEquals(4, 1.a.a.a)
        val i = 8
        assertEquals(7, i.b)
        i.b = 8
        try {
            i.b = 9
            throw Exception()
        } catch (ignore: AssertionError) {
        }
    }
    val Int.a
    get() = this + 1
    var Int.b: Int
    get() = this - 1
    set(o) = assertTrue(o == 8)
}

