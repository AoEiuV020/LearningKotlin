package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class ClassTest {
    var mOrder = 0
    @Test
    fun order() {
        mOrder = 0
        var c = C(0)
        assertEquals(3, mOrder)
        mOrder = 0
        c = C()
        assertEquals(3, mOrder)
    }
    inner open class A {
        init {
            assertEquals(0, mOrder)
            ++mOrder
        }
    }
    inner open class B: A() {
        init {
            assertEquals(1, mOrder)
            ++mOrder
        }
    }
    inner class C(i: Int = 0): B() {
        init {
            assertEquals(2, mOrder)
            ++mOrder
            assertEquals(0, i)
        }
    }

    @Test
    fun kConstruct() {
        //D d = D()
        //assertEquals(0, d.i)
    }
    data class D(val i: Int = 0) {
    }
    class E(i: Int = 0) {
    }

    @Test
    fun setter() {
        val f = F()
        assertNull(f.s)
        f.s = "v"
        assertNull(f.s)
    }

    class F() {
        var s: String? = null
            set(value) {
                assertEquals("v", value)
            }
    }

    @Test
    fun setterField() {
        val g = G()
        assertNull(g.s)
        g.s = "g"
        assertEquals("g", g.s)
    }

    class G() {
        var s: String? = null
            set(value) {
                assertEquals("g", value)
                field = value
            }
    }
}

