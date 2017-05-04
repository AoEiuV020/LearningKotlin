package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/04.
 */
class ExtensionFunctionTest {
    @Test
    fun add() {
        fun Int.isPositive(): Boolean = this > 0
        assertTrue(8.isPositive())
        //不行，kotlin的反射还不完善，下面两句在kotlinc命令行正确，
        //assertEquals(0, Int::class.declaredMemberExtensionFunctions.size)
        //assertEquals(0, Int.javaClass.kotlin.memberExtensionFunctions.size)
    }
}

