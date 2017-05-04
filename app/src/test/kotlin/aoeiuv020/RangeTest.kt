package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class RangeTest {
    @Test
    fun range() {
        val r = (1..3)
        assertEquals(r, IntRange(1, 3))
        assertEquals(r, 1.rangeTo(3))
        assertEquals("1..3", r.toString())
        assertEquals("kotlin.ranges.IntRange", IntRange::class.java.name)
        assertEquals(IntRange::class.java, r::class.java)
        assertEquals(IntRange::class.java, r.javaClass)
        assertEquals("kotlin.ranges.IntRange\$Companion", IntRange.javaClass.name) //w: confusion
        assertEquals(1, r.first)
        assertTrue(r.javaClass.methods.any {it.name == "getFirst"})
        assertFalse(r.javaClass.declaredMethods.any {it.name == "getFirst"}) //???
        assertEquals(3, r.last)
        assertEquals(1, r.step)
        assertEquals(1, r.start)
        assertEquals(3, r.endInclusive)
        assertTrue(r.contains(2))
        assertFalse(r.isEmpty())
        var index = 0
        for (it in r) {
            assertEquals(++index, it)
        }
        index = 0
        r.forEach {
            assertEquals(++index, it)
        }
    }

    /**
    * 基本上都是Iterator的拓展方法，
    */
    @Test
    fun extension() {
        val r = (1..3)
        assertFalse(r.any {it < 0})
        //拓展方法反射不到，
        assertFalse(r.javaClass.methods.any {it.name.toLowerCase().contains("any")})
        assertEquals(3, r.count())
        assertEquals(6, r.sum())
        assertEquals(2.0, r.average())
        assertEquals((1..3) step 2, r.step(2))
        assertTrue(2 in r)
        assertTrue(0 !in r)
    }

    @Test
    fun step() {
        val r = (1..4)
        assertEquals(4, r.last)
        assertEquals(3, r.step(2).last)
    }

    @Test
    fun downTo() {
        val d = 3 downTo 1
        assertEquals("3 downTo 1 step 1", d.toString())
        assertEquals(d, 3.downTo(1))
        assertEquals(d, (1..3).reversed())
    }
}

