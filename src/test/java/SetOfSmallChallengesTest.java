import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetOfSmallChallengesTest {

    /*
    O(n) anagram
     */
    @Test
    public void anagram_Test() {

        boolean result = anagram("williamshakespeare", "iamaweakishspeller");

        assertThat(result).isEqualTo(true);
    }


    @Test
    public void isPrime_Test() {
        int[] primes = new int[]{
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
                181, 191, 193, 197, 199
        };

        for (int i = 0; i < primes.length; i++) {
            boolean result = isPrime(primes[i]);
            assertThat(result).isEqualTo(true);
        }

    }

    @Test
    public void isPalindrome_Test() {
        String[] palindromes = new String[]{
                "Able was I ere I saw Elba",
                "Never odd or even",
                "madam",
                "racecar",
                "Was it a car or a cat I saw"
        };

        for (String sentenceOrWord : palindromes) {
            boolean result = isPalindrome(sentenceOrWord);
            assertThat(result).isEqualTo(true);
        }

    }

    @Test
    public void howManyPalindromesAreInAWord_Test() {
        String word = "barbarabar";

        Set<String> palindromes = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {

            palindromes.add(String.valueOf(word.charAt(i)));

            for (int j = i + 2; j <= word.length(); j++) {

                String tmp = word.substring(i, j);

                if (isPalindrome(tmp)) {
                    palindromes.add(tmp);
                }
            }
        }

        for (String w : palindromes) {
            System.out.println(w);
        }

        assertThat(palindromes.size()).isEqualTo(7);

    }

    private boolean isPalindrome(String s) {
        if (s.length() < 2) return true;

        s = s.toLowerCase().replaceAll("\\s+", "");

        int midPoint = s.length() / 2;

        for (int i = 0, j = s.length() - 1; i <= midPoint && j >= midPoint; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }

        return true;

    }

    private boolean anagram(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        int sum = 0;
        for (int i = 0; i < s1.length(); sum += s1.charAt(i) - s2.charAt(i), i++) ;

        return sum == 0;
    }

    private boolean isPrime(int n) {

        if (n == 1) return true;
        else {
            int sqrt = (int) Math.sqrt(n);

            for (int i = 2; i <= sqrt; i += 2) if (n % i == 0) return false;

            return true;
        }
    }
}
