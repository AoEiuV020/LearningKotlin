package aoeiuv020;
import java.util.*;
import java.io.*;
/**
 * Created by AoEiuV020 on 2017/05/07.
 */
public class AnonymousTestJava {
    public int get(IAJava ia) {
        return ia.get();
    }

    interface IAJava {
        int get();
    }
}

