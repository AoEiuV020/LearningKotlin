package aoeiuv020
import org.junit.Test
import kotlin.test.*

class BasicSyntaxTest {
    @Test
    fun readOnly() {
        val r = 0
        // r = 1 // Val cannot be reassigned
        assertEquals(0, r)
        var v = 1
        assertEquals(1, v)
        v = 2
        assertEquals(2, v)
    }
    @Test
    fun string() {
        var i = 0
        var s = "a$i"
        assertEquals("a0", s)
        i = 1
        assertEquals("a0", s)
        s = "b${++i}"
        assertEquals("b2", s)
        assertEquals(2, i)
        s = "$s.length"
        assertEquals("b2.length", s)
        s = "$i++"
        assertEquals("2++", s)
        assertEquals(2, i)
        s = "$++i"
        assertEquals("\$++i", s)
        s = "\$i"
        assertEquals("\$i", s)
        s = "${s.length}"
        assertEquals("2", s)
    }
    fun comment() {
        /* block comment 
        /* inner block comment */
        fail()
        */
        // fail()
    }
    @Test
    fun number() {
        var i = 0xff_ee_dd
        assertEquals(0xffeedd, i)
        i = 0b0110_1100
        assertEquals(0x6c, i)
    }
}
