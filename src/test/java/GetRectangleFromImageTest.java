import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetRectangleFromImageTest {

    /*
        There is an image which is presented as a simple 2D array where every pixel is a 1 or a 0.
        The image you get is known to have a single rectangle of 0s on a background of 1s.
        Write a function that takes in the image and returns the coordinates of the rectangle
        either top-left and bottom-right; or top-left, width, and height.

        Outputs:
        Format1: {x: 3, y: 2, width: 3, height: 2}
        Format2: [2, 3, 3, 5]
     */
    @Test
    public void getRectangleFromImage_Test() {

        // Time Complexity  : O(N)

        int[][] image = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[] result = getRect(image);

        System.out.println(
                String.format(
                        "x: %1$s, y: %2$s, width: %3$s, height: %4$s",
                        result[0], result[1], result[2], result[3]));

        assertThat(result[0]).isEqualTo(3);
        assertThat(result[1]).isEqualTo(2);
        assertThat(result[2]).isEqualTo(3);
        assertThat(result[3]).isEqualTo(2);
    }

    static int[] getRect(int[][] image) {
        Boolean rectFound = false;
        int x = 0, y = 0, width = 0, height = 0;

        for (int i = 0; i < image[0].length; i++) {

            int[] arr = image[i];
            if (rectFound) {
                if (arr[x] == 0) {
                    height++;
                }
            } else {

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == 0) {
                        if (rectFound) {
                            width++;
                        } else {
                            x = j;
                            y = i;
                            width++;
                            rectFound = true;
                        }
                    }

                    if (arr[j] == 1 && rectFound) break;
                }

                if (rectFound) {
                    height++;
                }
            }
        }

        return new int[]{x, y, width, height};
    }
}
