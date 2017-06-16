package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/03.
 */
class LoopTest {
    @Test
    fun forTest() {
        var index = 0
        val nonnullItemArray = arrayOf(1, 2, 3)
        for (it in nonnullItemArray) {
            assertEquals(++index, it)
        }
        index = 0
        val nullableItemArray = arrayOf(1, 2, null, 3)
        for (it in nullableItemArray) {
            it?.let {
                i -> assertEquals(++index, i)
            }
        }
        //for (it: Int in arrayOf(1, 2, null, 3)) {} //e: The loop iterates over values of type Int? but the parameter is declared to be Int
        index = 0
        for (ind in nonnullItemArray.indices) {
            assertEquals(index, ind)
            assertEquals(++index, nonnullItemArray[ind])
        }
        index = 0
        for ((ind, value) in nonnullItemArray.withIndex()) {
            assertEquals(index, ind)
            assertEquals(++index, value)
        }
        index = 0
        for (it in (1..3)) {
            assertEquals(++index, it)
        }
        assertEquals(3, index)
    }

    @Test
    fun doWhile() {
        var i = 0
        do {
            var j = i++
        } while (j < 10) // j is visible here!
        assertEquals(11, i)
    }

    @Test
    fun repeat() {
        var i = 0;
        repeat(8) {
            assertEquals(i, it)
            ++i
        }
        assertEquals(8, i)
    }
}

