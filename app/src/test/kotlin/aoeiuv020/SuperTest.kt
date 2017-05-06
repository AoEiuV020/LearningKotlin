package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class SuperTest {
    companion object {
        @JvmField var mOrder = 0
    }

    @Test
    fun superTest() {
        mOrder = 0
        var ca = CA()
        ca.b()
        assertEquals(3, mOrder)
        ++mOrder
        ca.a()
        assertEquals(6, mOrder)
        ++mOrder
        ca.c()
        assertEquals(8, mOrder)
    }

    interface IA {
        fun a()
        fun b() {
            assertEquals(0, SuperTest.mOrder)
            ++SuperTest.mOrder
        }
        fun c() {
            assertEquals(7, SuperTest.mOrder)
            ++SuperTest.mOrder
        }
    }
    
    inner open class IB {
        open fun a() {
            assertEquals(4, mOrder)
            ++mOrder
        }
        open fun b() {
            assertEquals(1, mOrder)
            ++mOrder
        }
    }

    inner class CA: IA,IB() {
        //必须继承，
        override fun a() {
            super<IB>.a()
            assertEquals(5, mOrder)
            ++mOrder
        }
        //必须继承，
        override fun b() {
            super<IA>.b()
            super<IB>.b()
            assertEquals(2, mOrder)
            ++mOrder
        }
    }
}

