package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
class EnumTest {
    @Test
    fun enumTest() {
        val r = RBG.RED
        assertEquals("RED", r.name)
        val b = RBG.valueOf("BLUE")
        assertEquals(RBG.BLUE, b)
        assertEquals(3, RBG.values().size)
    }

    enum class RBG {
        RED, BLUE, GREEN
    }
}

