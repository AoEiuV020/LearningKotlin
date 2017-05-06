package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
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
        val cc1: CC<Number> = CC()
        val cc2: CC<Any> = cc1
        //val cc2: CC<Int> = cc1 //e: Type mismatch
    }

    class CA<T>
    class CB<in T>
    class CC<out T>
}

