package aoeiuv020;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by AoEiuV020 on 2017/05/04.
 */
public class ClassTestJava {
    @Test
    public void jConstructor() throws Exception {
        Class<?> c = ClassTest.C.class;
        try {
            c.getDeclaredConstructor();
            fail();
        } catch (NoSuchMethodException ignore) {
        }
        //奇怪了，javap -v看到的参数列表没有ClassTest, 但能正常反射，
        // 反馈到官方社区看看，
        // https://discuss.kotlinlang.org/t/why-javap-get-wrong-signature-of-kotlin-inner-classs-constructor/2545
        // public aoeiuv020.ClassTest$C(int);
        //  descriptor: (Laoeiuv020/ClassTest;I)V
        c.getDeclaredConstructor(ClassTest.class, int.class);
        Class<?> d = ClassTest.D.class;
    }
}

