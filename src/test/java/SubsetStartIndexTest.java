import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubsetStartIndexTest {

    /*
    Returns start index of subset if one contains another for given lists, otherwise returns -1 
    (lists will not be empty)
    
    Given input:
    3 -> size of first list
    1
    3
    2
    2 -> size of second list
    3
    2

    Expected: 1
     */
    @Test
    public void find_Index_Test() {
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 4, 5, 3, 2));

        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(3, 2));

        int index = find(list1, list2);

        assertThat(index).isEqualTo(5);
    }

    // ⚠ : Not optimized
    private static int find(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i <= list1.size() - list2.size(); i++) {
            if (list1.get(i).equals(list2.get(0))) {

                Boolean found = true;
                for (int j = 1; j < list2.size() && found; j++) {
                    if (!list1.get(i + j).equals(list2.get(j))) {
                        found = false;
                    }
                }

                if (found) return i;
            }
        }

        return -1;
    }
}
