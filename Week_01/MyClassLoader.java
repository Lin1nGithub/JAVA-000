import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * x = x - 255
 */
public class MyClassLoader extends ClassLoader{

    final int offset = 255;

    public Class transport(String name, String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        int len = bytes.length;
        for (int i = 0; i < len; i++) {
            bytes[i] = (byte) ((byte) offset - bytes[i]);
        }

        return this.defineClass(name, bytes, 0, len);
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //xlass file path
        String filePath = System.getProperty("user.dir") + File.separator + "Week_01" + File.separator + "Hello.xlass";

        //custom define classLoader with byte offset
        MyClassLoader classLoaderWithOffset = new MyClassLoader();
        Class helloClass = classLoaderWithOffset.transport("Hello", filePath);

        //get a instance of hello,xlass and call method hello
        Method helloMethod = helloClass.getDeclaredMethod("hello");
        helloMethod.invoke(helloClass.newInstance());
    }
}
