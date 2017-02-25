import org.junit.Test;

import java.util.Stack;

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

        Plus: Get multiple rectangle from image
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

        int[] rectangle = getRectangle(image);

        int x = rectangle[0];
        int y = rectangle[1];
        int width = rectangle[2];
        int height = rectangle[3];
        System.out.println(String.format("x: %d, y: %d, width: %d, height: %d", x, y, width, height));

        assertThat(x).isEqualTo(3);
        assertThat(y).isEqualTo(2);
        assertThat(width).isEqualTo(3);
        assertThat(height).isEqualTo(2);
    }

    @Test
    public void getRectangleMultipleFromImage_Test() {

        int[][] image = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        Stack<int[]> rectangles = getRectangles(image);

        for (int[] rectangle : rectangles) {
            System.out.println(
                    String.format("x: %d, y: %d, width: %d, height: %d",
                            rectangle[0], rectangle[1], rectangle[2], rectangle[3]));
        }
    }

    // NOT OPTIMIZED
    private static Stack<int[]> getRectangles(int[][] image) {
        Stack<int[]> rectangles = new Stack<>();
        // array desc: [x, y, width, height]

        Boolean rectFound = false;
        for (int i = 0; i < image[0].length; i++) {

            int[] row = image[i];

            //increase height of rectangles which already found
            if (rectangles.size() > 0) {
                for (int[] rectangle : rectangles) {
                    if (row[rectangle[0]] == 0) {
                        rectangle[3]++;//increase height of rectangle
                    }
                }
            }

            // find rectangle and calculate width (height=1)
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    // if rectangle exists on the x coordinate break and try to find another one
                    if (rectangles.size() > 0 && j == rectangles.lastElement()[0] /* x */) {
                        break;
                    } else {
                        if (rectFound) {
                            // increase width of current rectangle which is last element of stack
                            rectangles.lastElement()[2]++;

                        } else {

                            rectFound = true;
                            // [x, y, width, height]
                            rectangles.add(new int[]{j, i, 1, 1});
                        }
                    }

                }

                if (row[j] == 1 && rectFound) {
                    rectFound = false;
                    break;
                }
            }
        }

        return rectangles;
    }

    private static int[] getRectangle(int[][] image) {
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
                            height++;
                        }
                    }

                    if (arr[j] == 1 && rectFound) break;
                }
            }
        }

        return new int[]{x, y, width, height};
    }
}
