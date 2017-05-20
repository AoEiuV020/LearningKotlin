package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/20.
 */
class FunctionTest {
    @Test
    fun anonymous() {
        val l = fun (i: Int) = i + 1
        assertEquals(9, l(8))
        assertEquals("class aoeiuv020.FunctionTest\$anonymous\$l\$1", l::class.toString())
    }

    @Test
    fun lambda() {
        val l = {i:Int -> i + 1}
        fun f(i: Int) = i + 1
        assertEquals(9, l(8))
        assertEquals(9, f(8))
        val l1 = ::f
        assertEquals(9, l1(8))
    }

    /**
     * lambda无法递归，函数可以，
     * 主要是lambda没有名字，又不能用this代表自己，
     * 把lambda赋值给一个对象的话，lambda内还是没有定义这个对象，
     * 只能先定义一个对象，然后再写lambda，
     * https://zhuanlan.zhihu.com/p/27011297
     * https://youtrack.jetbrains.com/issue/KT-17980
     */
    @Test
    fun recursion() {
        fun f(i: Int): Int = if (i <= 2) 1 else f(i - 1) + f(i - 2)
        assertEquals(8, f(6))
        //val l = { i: Int -> if (i <= 2) 1 else l(i - 1) + l(i - 2) } //e: Unresolved reference: l
        var l1: (Int) -> Int = { 0 }
        l1 = { i -> if (i <= 2) 1 else l1(i - 1) + l1(i - 2) }
        assertEquals(8, l1(6))
        val l2 = ::f
        assertEquals(8, l2(6))
    }

    @Test
    fun invoke() {
        val ca = CA()
        assertEquals(0, ca.invoke())
        assertEquals(0, ca())
    }

    class CA {
        operator fun invoke() = 0
    }
}

