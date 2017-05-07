package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
class AnonymousTest {
    @Test
    fun anonymous() {
        //java类中的方法参数如果是inteface可以传入lambda，
        val cj = AnonymousTestJava()
        assertEquals(8, cj.get(object: AnonymousTestJava.IAJava {
            override fun get() = 8
        }))
        assertEquals(7, cj.get { 7 })
        //kotlin类不行，参数是java interface也不行，
        val ca = CA()
        assertEquals(0, ca.get(object: IA {
            override fun get() = 0
        }))
        //assertEquals(5, ca.get(IA{5})) //e: Interface IA does not have constructors
        fun IA(l: () -> Int) = object: IA {
            override fun get() = l()
        }
        assertEquals(1, ca.get(IA{1}))
        val cb = CB()
        assertEquals(2, cb.get { 2 })
        assertEquals(3, cb.get(fun() = 3))
    }

    interface IA {
        fun get(): Int
    }

    class CA { 
        fun get(ia: IA) = ia.get()
    }

    class CB { 
        fun get(l: () -> Int) = l()
    }
}

