import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ConvertBaseSevenTest {

    /*
    Complete the function that takes an integer as its argument and returns the encoded string in base 7
    using the following encoding rule:
    base 10 0 1 2 3 4 5 6
    base 7  0 a t l s i N

    Sample Input  : 7
    Sample Output : a0

    NOTE: input can be bigger than 2^63-1 (long)
     */

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "7", "a0" }
        });
    }

    @Parameterized.Parameter
    public  String input;

    @Parameterized.Parameter(1)
    public String expected;

    @Test
    public void toBaseSeven_Test() {
        BigInteger bInput = new BigInteger(input);

        String result = toBase7(bInput);

        assertThat(result).isEqualTo(expected);
    }

    private static String toBase7(BigInteger input) {
        StringBuilder builder = new StringBuilder();
        BigInteger base = new BigInteger("7");

        while (input.compareTo(BigInteger.ZERO) != 0) {
            builder.append(getChar(input.mod(base).intValue()));
            input = input.divide(base);
        }

        return  builder.reverse().toString();
    }

    private static char getChar(int number) {
        char[] array = {'0', 'a', 't', 'l', 's', 'i', 'N'};
        return array[number];
    }
}
