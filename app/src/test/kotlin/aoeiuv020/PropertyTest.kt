package aoeiuv020

import org.junit.Test
import kotlin.test.*
import kotlin.reflect.*

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
class PropertyTest {
    @Test
    fun property() {
        val ca = CA()
        assertEquals(0, ca.i)
        val kp = ca::i
        assertTrue(kp is KProperty<Int>)
        assertTrue(kp.returnType is KType)
        assertEquals("kotlin.Int", kp.returnType.toString())
        assertEquals("i", kp.name)
        assertTrue(kp.isFinal)
        assertTrue(kp.getter is KProperty.Getter<Int>)
        assertEquals(ca.i, kp.getter())
        assertEquals(ca.i, (kp.getter)())
        //assertEquals(ca.i, kp.(getter())) //e: The expression cannot be a selector (occur after a dot)
    }

    class CA {
        var i = 0
    }
}

