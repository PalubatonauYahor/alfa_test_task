package alfa.utils;

public class AppConfig {

    public static String getParameterByName(String parameter) {
        return System.getenv(parameter);
    }
}
