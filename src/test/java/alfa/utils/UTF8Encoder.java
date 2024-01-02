package alfa.utils;

import java.nio.charset.StandardCharsets;

public class UTF8Encoder {

    public static String encodeToUTF8(String string){
        return new String(string.getBytes(), StandardCharsets.UTF_8);
    }
}
