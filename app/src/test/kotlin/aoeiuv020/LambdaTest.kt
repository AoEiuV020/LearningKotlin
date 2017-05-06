package aoeiuv020

import org.junit.Test
import kotlin.test.*

/**
 * Created by AoEiuV020 on 2017/05/06.
 */
class LambdaTest {
    @Test
    fun bug() {
        //下面这个表达示导致编译器抛异常，反馈bug,
        // https://youtrack.jetbrains.com/issue/KT-17769
        //{i->}() //e: org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression at
    }
}

