package aoeiuv020

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by AoEiuV020 on 2017/05/02.
 */
class ArrayTest {
    @Test
    fun array() {
        val arrayString = Array(3, {i -> i.toString()})
        assertEquals(3, arrayString.size)
        //assertEquals(3, arrayString.length) // Unresolved reference: length
        assertEquals("[Ljava.lang.String;", arrayString.javaClass.name)
        assertEquals("String[]", arrayString.javaClass.simpleName)
        assertEquals(0, arrayString[0].toInt())
        assertEquals(2, arrayString.get(2).toInt())
        var arrayInt = IntArray(3, {i -> i + 1})
        assertEquals("[I", arrayInt.javaClass.name)
        assertEquals("int[]", arrayInt.javaClass.simpleName)
        assertEquals(1, arrayInt[0])
        arrayInt = intArrayOf(8, 9)
        assertEquals(2, arrayInt.size)
        assertEquals(8, arrayInt[0])
        var arrayInteger = Array(3, {i -> i + 2})
        assertEquals("[Ljava.lang.Integer;", arrayInteger.javaClass.name)
        assertEquals("Integer[]", arrayInteger.javaClass.simpleName)
        assertEquals(2, arrayInteger[0])
        arrayInteger = arrayOf(6, 7)
        assertEquals("int", arrayInteger[0].javaClass.name)
        assertEquals("Integer", arrayInteger[0]::class.java.simpleName)
        assertEquals("int", "${arrayInteger[0]::class.javaPrimitiveType}")
        assertEquals(2, arrayInteger.size)
        assertEquals(6, arrayInteger[0])
    }
}

