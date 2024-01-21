import java.util.Arrays;

public class ArrayUtils {
    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        // Deep copies the arrays before sorting
        int[][] sortedM1 = deepCopyAndSort(m1);
        int[][] sortedM2 = deepCopyAndSort(m2);

        // Compare the arrays
        return Arrays.deepEquals(sortedM1, sortedM2);
    }

    private static int[][] deepCopyAndSort(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
            Arrays.sort(copy[i]);
        }
        return copy;
    }
}