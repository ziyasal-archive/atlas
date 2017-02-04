import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LookAndSayTest {

    /*
    Look-and-say sequence :)

    - Starting with the number 1,   you have one 1 which produces 11
    - Starting with 11,   you have two 1's.   I.E.:   21
    - Starting with 21,   you have one 2, then one 1.   I.E.:   (12)(11) which becomes 1211
    - Starting with 1211,   you have one 1, one 2, then two 1's.   I.E.:   (11)(12)(21) which becomes 111221

    Given input:
    11
    2  -> n  times

    Expected: 1211
     */
    @Test
    public void  lookAndSay_Test() {
        String start = "11";
        int n = 2;

        String result = LookAndSay(start, n);

        assertThat(result).isEqualTo("1211");
    }

    private static String LookAndSay(String input, int n) {

        while(n-- > 0){
            input = LookAndSay(input);
        }

        return input;
    }

    private static String LookAndSay(String input) {

        char previousChar= input.charAt(0);
        int counter =1;
        StringBuilder result= new StringBuilder();

        for (int i = 1; i < input.length(); i++) {

            char c = input.charAt(i);
            if(c == previousChar){
                counter++;
            }else{
                result.append(counter);
                result.append(previousChar);
                previousChar = c;
            }
        }

        result.append(counter);
        result.append(previousChar);

        return result.toString();
    }
}
