package hexlet.code;

public class Util {

    public static boolean  checkClass(Object o, Class clazz) {
        try {
            clazz.cast(o);
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
