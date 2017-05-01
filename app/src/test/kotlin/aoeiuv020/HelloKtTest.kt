package aoeiuv020
import org.junit.Test
import kotlin.test.*;

class HelloKtTest {
    @Test
    fun test() {
        assertEquals(1, 1)
        try {
            fail()
        }catch(ignore: AssertionError) {
        }
    }
}
