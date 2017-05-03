package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/03.
 */
class NullTest {
    @Test
    fun nullTest() {
        //TODO w: Parameter 'nonnull' is never used
        fun argNonnull(nonnull: String) {}
        fun argNullable(nullable: String?) {}
        fun getNull(): String? = null
        fun getString(): String = "nonnull"
        fun getNullableString(): String? = "nullable"
        assertNull(getNull())
        assertNotNull(getString())
        assertNotNull(getNullableString())
        assertEquals("nullable", getNullableString() ?: "?:")
        assertEquals("?:", getNull() ?: "?:")
        try {
            val nonnullString = getNull()!!
            fail(nonnullString)
        } catch (ignore: NullPointerException) {
        }
        try {
            // w: Unreachable code
            // w: Variable 'nonnullString' is never used
            val nonnullString = null!!
            // w: Unreachable code
            fail(nonnullString)
        } catch (ignore: NullPointerException) {
        }
        val nonnullString = getNullableString()!!
        assertNotNull(nonnullString)
        assertEquals(getNullableString(), nonnullString)
        assertEquals(8, getNullableString()?.length ?: -1)
        assertEquals(-1, getNull()?.length ?: -1)
        val nonnullInt = getNull()?.length
        assertNull(nonnullInt)
    }

    @Test
    fun safeCasts() {
        fun getObject(): Any = "str"
        val str = getObject()
        val i: Int? = str as? Int
        assertNull(i)
    }

    @Test
    fun listTypeNullable() {
        val list = listOf(1, 2, null, 4)
        assertEquals("java.util.Arrays\$ArrayList", list.javaClass.name)
        val nullableList: List<Int?> = list
        assertEquals(4, nullableList.size)
        val nonnullList: List<Int> = nullableList.filterNotNull()
        assertEquals(3, nonnullList.size)
        assertEquals("[1, 2, 4]", nonnullList.toString())
        //nonnullList = nullableList // Type mismatch: inferred type is List<Int?> but List<Int> was expected
    }
}

