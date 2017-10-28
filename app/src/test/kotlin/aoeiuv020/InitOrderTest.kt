package aoeiuv020

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by AoEiuV020 on 2017.10.28-21:31:24.
 */
class InitOrderTest {
    @Test
    fun order() {
        val ca = CA()
        assertEquals("anull", ca.b)
    }
    class CA {
        private val a: String = "a"
        // val b = c // e: Variable 'c' must be initialized
        // 上下顺序，a已经初始化为a, c没初始化，为null,
        val b: String = "".run { plus(a).plus(c) }
        private val c: String = "c"
    }
}