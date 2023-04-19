package utility;

import lombok.experimental.UtilityClass;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class StringUtils {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
    private static final Random random = new Random();

    public static String randomString(int size) {
        return IntStream
                .range(0, size)
                .map(i -> random.nextInt(ALPHABET.length()))
                .mapToObj(rand -> String.valueOf(ALPHABET.charAt(rand)))
                .collect(Collectors.joining());
    }
}
