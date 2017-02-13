import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramTest {

    /*
    O(n) anagram
     */
    @Test
    public void anagram_Test() {

       boolean result = anagram("williamshakespeare", "iamaweakishspeller");

        assertThat(result).isEqualTo(true);
    }

    private boolean anagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;

        int sum = 0;
        for( int i=0; i<s1.length(); sum += s1.charAt(i) - s2.charAt(i), i++);
        return sum == 0;
    }
}
