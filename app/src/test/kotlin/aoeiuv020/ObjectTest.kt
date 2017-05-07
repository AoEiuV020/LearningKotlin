package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
class ObjectTest {
    @Test
    fun objectTest() {
        assertEquals("s", OA.s)
        assertEquals("jfs", OA.jfs)
        assertEquals("jss", OA.jss)
    }

    object OA {
        var s: String = "s"
        @JvmField
        var jfs: String = "jfs"
        @JvmStatic
        var jss: String = "jss"
    }

    @Test
    fun objectReflect() {
        val c = OA.javaClass
        assertEquals("aoeiuv020.ObjectTest\$OA", c.name)
        val m = c.getMethod("getS")
        assertEquals("s", m.invoke(OA))
        val fInstance = c.getField("INSTANCE")
        val instance = fInstance.get(null)
        assertEquals("s", m.invoke(instance))
        assertEquals(OA, instance)
        try {
            assertEquals("s", m.invoke(null))
            fail()
        } catch (ignore: NullPointerException) {
        }
        val mJss = c.getMethod("getJss")
        assertEquals("jss", mJss.invoke(OA))
        assertEquals("jss", mJss.invoke(null))
        try {
            c.getMethod("getJfs")
            fail()
        } catch (ignore: NoSuchMethodException) {
        }
        val fJfs = c.getField("jfs");
        assertFalse(fJfs.isAccessible)
        assertEquals("jfs", fJfs.get(null))
    }
}

