package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class BitTest {
    @Test
    fun operatorTest() {
        val a = 0b1101
        val b = 0b0111
        assertEquals(0b0101, a and b)
        assertEquals(a and b , a.and(b))
        assertEquals(0b1111, a or b)
        assertEquals(0b1010, a xor b)
        assertEquals(0b0010 or (-1 shl 4), a.inv())
        assertEquals(0b1_1010, a shl 1)
        assertEquals(0b0110, a shr 1)
        assertEquals(a shr 1, a ushr 1)
        assertNotEquals(-a shr 1, -a ushr 1)
        assertEquals(-a shr 1, -a ushr 1 or (1 shl 31))
    }
}

