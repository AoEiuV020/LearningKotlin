package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
class ListTest {
    @Test
    fun list() {
        val l = listOf(1, 2, 3)
        assertEquals(3, l.size)
        assertEquals(listOf(1, 2, 3), l)
        assertFalse(arrayOf(1, 2, 3) == l)
        assertEquals("java.util.Arrays\$ArrayList", l.javaClass.name)
        //l.add(0) //e: unresolved reference: add
        assertEquals(listOf(1, 3), l.filter { it % 2 == 1 })
    }

    @Test
    fun mutableList() {
        val l = mutableListOf(1, 2, 3)
        assertEquals(listOf(1, 2, 3), l)
        assertEquals(arrayListOf(1, 2, 3), l)
        //简直,这个不知道两边那里不一样了，
        //assertEquals(arrayListOf(1, 2, 3).javaClass, l.javaClass) //e: Type inference failed.
        assertTrue(arrayListOf(1, 2, 3).javaClass == l.javaClass)
        assertEquals(arrayListOf(1, 2, 3)::class, l::class)
        l.add(4)
        assertEquals(listOf(1, 2, 3, 4), l)
        //简直,这两个怎么不等了，
        assertNotEquals(listOf(1).javaClass, l.toList().javaClass)
        assertNotEquals(listOf(1)::class, l.toList()::class)
        assertEquals(l.javaClass, l.toList().toMutableList().javaClass)
    }

    @Test
    fun setTest() {
        val s = setOf(1, 2, 3, 2)
        assertEquals(3, s.size)
        assertEquals(setOf(1, 2, 3), s)
        assertEquals(hashSetOf(1, 2, 3), s)
        assertFalse(hashSetOf(1, 2, 3).javaClass == s.javaClass)
    }

    @Test
    fun mapTest() {
        val m = mapOf("first" to 1)
        assertEquals("java.util.Collections\$SingletonMap", m.javaClass.name)
    }
}

