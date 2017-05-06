package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class WhenTest {
    @Test
    fun whenTest() {
        //w: Parameter 'obj' is never used
        fun failCheck(obj: Any): Boolean { fail() }
        fun checkBoolean(obj: Any): Boolean = (obj as? String)?.equals("ok") ?: false
        fun w(obj: Any?): String = when (obj) {
            null -> "null"
            //没用，failCheck方法根本不会被调用，
            ::failCheck -> "fail"
            //没用，最终判断的结果是obj不等于true,
            checkBoolean(obj) -> "checkBoolean"
            //强行Boolean，检查通过就返回obj，obj自然等于obj，于是跳到这个case,
            if (checkBoolean(obj)) obj else null -> "if (checkBoolean(obj)) obj else null"
            "before" -> "before"
            is String -> "is String"
            "after" -> "after"
            !is Int -> "!is Int"
            8, 9, 10 -> "8, 9, 10"
            in 0..3 -> "in 0..3"
            if (obj < 0) obj else null -> "< 0"
            in 11..Int.MAX_VALUE -> "> 10"
            else -> "else"
        }
        assertEquals("null", w(null))
        assertTrue(checkBoolean("ok"))
        assertEquals("if (checkBoolean(obj)) obj else null", w("ok"))
        assertEquals("before", w("before"))
        assertEquals("is String", w("string"))
        assertEquals("is String", w("after"))
        assertEquals("!is Int", w('8'))
        assertEquals("8, 9, 10", w(9))
        assertEquals("in 0..3", w(2))
        assertEquals("< 0", w(-2))
        assertEquals("> 10", w(888))
        assertEquals("else", w(7))
    }

    @Test
    fun whenWithoutArg() {
        fun checkBoolean(obj: Any): Boolean = (obj as? String)?.equals("ok") ?: false
        fun wb(obj: Any?): String = when {
            obj == null -> "null"
            checkBoolean(obj) -> "check"
            obj !is Int -> "!is Int"
            obj > 0 -> "> 0"
            else -> "else"
        }
        assertEquals("check", wb("ok"))
        assertEquals("> 0", wb(888))
        assertEquals("else", wb(0))
    }
}

