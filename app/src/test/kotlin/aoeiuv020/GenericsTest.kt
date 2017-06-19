package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * https://kotlinlang.org/docs/reference/generics.html
 * Created by AoEiuV020 on 2017/05/06.
 */
class GenericsTest {
    @Test
    fun declarationSiteVariance() {
        val ca1: CA<Number> = CA()
        assertTrue(ca1 is CA)
        //val ca2: CA<Any> = ca1 //e: Type mismatch
        //val ca3: CA<Int> = ca1 //e: Type mismatch
        val cb1: CB<Number> = CB()
        //val cb2: CB<Any> = cb1 //e: Type mismatch
        val cb2: CB<Int> = cb1
        var any: Any
        cb1.set(1)
        cb2.set(1)
        val cc1: CC<Number> = CC(1.0)
        val cc2: CC<Any> = cc1
        //val cc2: CC<Int> = cc1 //e: Type mismatch
        any = cc1.get()
        assertEquals(1.0, any)
        assertEquals(Double::class, any::class)
        any = cc2.get()
        assertEquals(1.0, any)
    }

    class CA<T>
    class CB<in T> {
        fun set(t: T) {}
    }
    class CC<out T>(val t: T) {
        fun get(): T = t
    }
    
    /**
     * TODO CB, CC之里的行为和说好的不一样，
     * IF这里和说好的一样，CE也一样，
     */
    @Test
    fun star() {
        var cd1: CD<Int> = CD<Int>()
        cd1.set(8)
        var cd2: CD<Any> = CD<Any>()
        var cd3: CD<*>
        cd3 = cd1
        cd3 = cd2
        var cd4: CD<Double> = CD<Double>()
        cd4.set(8.8)
        var cd5: CD<Number>
        cd3 = cd1
        var cd31g = cd3.get()
        var cd31gi: Int = cd31g
        assertEquals(Int::class, cd31g::class)
        assertEquals(8, cd31g)
        cd3 = cd4
        var cd34g = cd3.get()
        var cd34gd: Double = cd34g
        assertEquals(Double::class, cd34g::class)
        assertEquals(8.8, cd34g)
        var cd6: CD<out Number>
        cd6 = cd1
        var cd61g = cd6.get()
        var cd61gi: Int = cd61g

        var cb1: CB<Int> = CB<Int>()
        cb1.set(9)
        var cb2: CB<Double> = CB<Double>()
        cb2.set(9.9)
        var cb3: CB<Number> = CB<Number>()
        var cb4: CB<*>
        var cb5: CB<Any> = CB<Any>()
        var cb6: CB<in Nothing>
        cb4 = cb1
        cb4.set(7)
        cb4 = cb2
        cb4.set(7.7)
        cb4 = cb3
        cb4.set(7)
        cb4 = cb5
        cb4.set("cb4")
        cb6 = cb5
        // in Nothing居然还能输入，这是自动转换成cb5的类型了？
        cb6.set("cb6")

        var cc1: CC<Int> = CC<Int>(5)
        var cc4: CC<*>
        var cc6: CC<out Any>
        cc4 = cc1
        var cc41g = cc4.get() //真的是自动转换成cc1了，
        var cc41gi: Int = cc41g
        cc6 = cc1
        var cc61g = cc6.get()
        var cc61gi: Int = cc61g

        var ifis: IF<Int, String> = object : IF<Int, String> {
            override operator fun invoke(t: Int) = t.toString()
        }
        var ifisg = ifis(4)
        var ifisgs: String = ifisg
        var ifos: IF<*, String> = ifis
        // 这才对，in Nothing就不能输入，
        //var ifosg = ifos(4) // e: Out-projected type ...
        var ifio: IF<Int, *> = ifis
        var ifiog = ifio(4)
        // 这才对，out Any就该返回Any,
        //Type mismatch: inferred type is Any? but String was expected
        //var ifiogs: String = ifiog
        assertEquals("4", ifiog)

        var ceis = CE<Int, String>("3")
        var ceos: CE<*, String> = ceis
        // 这才对，in Nothing就不能输入，
        //ceos.set(3) // e: Out-projected type ...

        // bug吧，反馈了，
        // https://youtrack.jetbrains.com/issue/KT-18532
        // 声明时初始化的*才有效，
        val cbi: CB<Int> = CB<Int>()
        val cbo: CB<*>
        cbo = cbi
        cbo.set(0)
        val cbo1: CB<*> = cbi
        // cbo1.set(0) // e: Out-projected type ...
    }

    class CD<T> {
        var t: T? = null
        fun set(t: T) {
            this.t = t
        }
        fun get(): T = t!!
    }
    interface IF<in T, out R> {
        operator fun invoke(t: T): R
    }
    class CE<in T, out R>(val r: R) {
        fun get(): R = r
        fun set(t: T) {
        }
    }
}

