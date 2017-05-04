package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class JumpTest {
    @Test
    fun breakAndContinueLabel() {
        var a = 0
        var b = 0
        o@ for (i in 1..4) {
            i@ for (j in 5..9) {
                if (i == 3) {
                    break@o
                } else if (j == 6) {
                    continue@i
                }
                ++b
            }
            ++a
        }
        assertEquals(2, a)
        assertEquals(8, b)
    }

    @Test
    fun returnLabel() {
        fun t(): Int {
            var i = 0
            (1..3).forEach r@ {
                it == 3 && return@r
                ++i
            }
            return i
        }
        assertEquals(2, t())
    }
}

