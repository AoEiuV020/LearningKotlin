package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/06.
 */
class DataClassTest {
    @Test
    fun dataClass() {
        var ca = CA()
        assertEquals("default", ca.name)
        assertEquals(20, ca.age)
        ca = CA("AoEiuV020")
        assertEquals("AoEiuV020", ca.name)
        assertEquals(20, ca.age)
        ca = CA(age = 22)
        assertEquals("default", ca.name)
        assertEquals(22, ca.age)
        try {
            ca.javaClass.getConstructor(String::class.java)
            fail()
        } catch (ignore: NoSuchMethodException) {
        }
        assertNotNull(ca.javaClass.getConstructor())
        assertNotNull(ca.javaClass.getConstructor(String::class.java, Int::class.java))
        try {
            ca.javaClass.getConstructor(String::class.java, Integer::class.java)
            fail()
        } catch (ignore: NoSuchMethodException) {
        }
    }
    data class CA(
            var name: String = "default",
            var age: Int = 20
    )

    @Test
    fun destructuring() {
        val ca = CA("AoEiuV020", 22)
        val (name, age) = ca
        //val p: Pair<String, Int> = ca //e: Type mismatch: inferred type is DataClassTest.CA but Pair<String, Int> was expected
        assertEquals("AoEiuV020", name)
        assertEquals(22, age)
    }

    @Test
    fun copy() {
        val ca1 = CA("AoEiuV020", 22)
        assertEquals("AoEiuV020", ca1.name)
        assertEquals(22, ca1.age)
        val ca2 = ca1.copy("ca2")
        assertEquals("ca2", ca2.name)
        assertEquals(22, ca2.age)

        //浅拷贝，
        val cb1 = CB()
        assertEquals("default", cb1.wrapper.name)
        val cb2 = cb1.copy()
        assertEquals("default", cb2.wrapper.name)
        cb2.wrapper.name = "AoEiuV020"
        assertEquals("AoEiuV020", cb2.wrapper.name)
        assertEquals("AoEiuV020", cb1.wrapper.name)

        //试试自己写深拷贝，
        val cc1 = CC()
        assertEquals("default", cc1.wrapper.name)
        val cc2 = cc1.deepCopy()
        assertEquals("default", cc2.wrapper.name)
        cc2.wrapper.name = "AoEiuV020"
        assertEquals("AoEiuV020", cc2.wrapper.name)
        assertEquals("default", cc1.wrapper.name)

    }
    data class CB(var wrapper: Wrapper = Wrapper("default"))
    data class Wrapper(var name: String)
    data class CC(var wrapper: Wrapper = Wrapper("default")) {
        fun deepCopy(wrapper: Wrapper = this.wrapper) = CC(wrapper.copy())
    }
}

