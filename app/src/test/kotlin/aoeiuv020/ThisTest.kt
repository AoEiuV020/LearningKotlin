package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
class ThisTest {
    @Test
    fun thisTest() {
        val cb = CB()
        assertEquals(3, cb.get())
        val cd = CC().CD()
        assertEquals(1, cd.increaseCD())
        assertEquals(2, cd.i)
        assertEquals(0, cd.increaseCC())
        assertEquals(1, cd.getCCI())
    }

    open class CA() {
        open fun get() = 1
    }
    
    class CB: CA() {
        //下面这句又导致编译抛异常，懒得反馈了，
        //override fun get() = 2 + this<CA>::get() //e: KotlinFrontEndException
        //override fun get() = 2 + this<CA>.get() //e: Expression 'this' of type 'ThisTest.CB' cannot be invoked as a function. The function 'invoke()' is not found
        //override fun get() = 2 + this@CA.get() //e: Unresolved reference: @CA
        override fun get() = 2 + super<CA>.get()
    }

    class CC {
        var i = 0
        inner class CD {
            var i = 1
            fun increaseCD() = i++
            fun increaseCC() = this@CC.i++
            fun getCCI() = this@CC.i
        }
    }
}

