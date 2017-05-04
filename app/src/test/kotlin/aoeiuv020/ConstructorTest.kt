package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class ConstructorTest {
    var mOrder = 0
    @Test
    fun constructorTest() {
        mOrder = 0
        //var a = A() // e: Cannot access '<init>': it is private in 'A'
        var a = A("s")
        assertEquals(2, mOrder)
    }

    inner class A(i: Int) {
        init {
            assertEquals(0, mOrder)
            ++mOrder
        }

        private constructor(): this(0) {
        }

        public constructor(s: String): this(0) {
            assertEquals(1, mOrder)
            ++mOrder
        }
    }
}

