import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperSimpleSumOfMatrixDiagonals {

    /*
     find the sum of the two diagonals and output the absolute value of the difference
     Input:
       [ [1, 2, 3], [4, 5, 6], [7, 8, 9] ]
     Output:
       abs((1+5+9)-(3+5+7))
     */
    @Test
    public void superSimpleSumOfMatrixDiagonals_Test() {
        int sumOfDiagonal1 = 0, sumOfDiagonal2 = 0;

        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int i = 0, j = array.length -1; i < array.length; i++, j--) {
            sumOfDiagonal1 += array[i][i];
            sumOfDiagonal2 += array[i][j];
        }


        int result = Math.abs(sumOfDiagonal1 - sumOfDiagonal2);

        assertThat(result).isEqualTo(0);
    }
}
