import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class SmallBidilarTest {

    /*
    O(n) anagram
     */
    @Test
    public void anagram_Test() {

        boolean result = anagram("williamshakespeare", "iamaweakishspeller");

        assertThat(result).isEqualTo(true);
    }

    private boolean anagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int sum = 0;
        for (int i = 0; i < s1.length(); sum += s1.charAt(i) - s2.charAt(i), i++) ;

        return sum == 0;
    }


    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[]{
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
                181, 191, 193, 197, 199
        };
    }

    @Parameterized.Parameter
    public int input;

    @Test
    public void isPrime_Test() {
        boolean result = isPrime(input);
        assertThat(result).isEqualTo(true);
    }

    private boolean isPrime(int n) {

        if (n == 1) {
            return true;
        } else {
            int sqrt = (int) Math.sqrt(n);

            for (int i = 2; i <= sqrt; i += 2) if (n % i == 0) return false;

            return true;
        }
    }
}
