package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/20.
 */
class SequenceTest {
    @Test
    fun generateSequence() {
        val g = generateSequence(1) { it * 10 }
        val t = g.take(10)
        var i = 1
        t.forEach {
            assertEquals(i, it)
            i *= 10
        }
    }
}

