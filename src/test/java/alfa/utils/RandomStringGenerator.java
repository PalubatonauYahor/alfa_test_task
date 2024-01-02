package alfa.utils;

import java.util.Random;

public class RandomStringGenerator {

    public static String generateRandomString(String length) {
        int leftLimit = 33;
        int rightLimit = 126;
        int targetStringLength = Integer.parseInt(length);
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}