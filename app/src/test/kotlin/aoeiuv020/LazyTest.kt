package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
class LazyTest {
    @Test
    fun lazyTest() {
        var ca = CA()
        assertEquals(0, ca.order)
        ++ca.order
        assertEquals(8, ca.i)
        assertEquals(2, ca.order)
    }

    class CA {
        var order = 0
        val i: Int by lazy {
            assertEquals(1, order)
            ++order
            8
        }
    }
}

