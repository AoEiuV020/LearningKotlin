package aoeiuv020;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
public class ObjectTestJava {
    @Test
    public void objectReflect() throws Exception {
        Class<?> c = ObjectTest.OA.class;
        Field fJfs = c.getField("jfs");
        assertFalse(fJfs.isAccessible());
        assertEquals("jfs", fJfs.get(null));
        try {
            c.getField("s");
            fail();
        } catch (NoSuchFieldException ignore) {
        }
    }
}

