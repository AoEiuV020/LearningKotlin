package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/06.
 */
class SealedClassTest {
    @Test
    fun sealedTest() {
        val caClass = CA::class.java
        val caConstructors = caClass.constructors
        assertEquals(1, caConstructors.size)
        assertEquals("class kotlin.jvm.internal.DefaultConstructorMarker", "${caConstructors[0].genericParameterTypes[0]}")
    }

    sealed class CA {
        class CB: CA()
    }
    //说好的外面的data class可以继承sealed class，
    //e: This type is sealed, so it can be inherited by only its own nested classes or objects
    //class CC: CA()
    //data class CC(): CA()
}

