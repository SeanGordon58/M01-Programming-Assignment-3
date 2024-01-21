import java.util.Scanner;

public class ArrayComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list1: ");
        int[][] m1 = enterMatrix(scanner);

        System.out.print("Enter list2: ");
        int[][] m2 = enterMatrix(scanner);

        if (areMatricesEqual(m1, m2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }
    }

    private static boolean areMatricesEqual(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false; // Matrices have different dimensions, not identical
        }

        int rows = m1.length;
        int cols = m1[0].length;

        // Create a copy of m2 to keep track of matched elements
        boolean[][] matched = new boolean[rows][cols];

        outerLoop:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currentElement = m1[i][j];

                // Find a matching element in m2
                for (int x = 0; x < rows; x++) {
                    for (int y = 0; y < cols; y++) {
                        if (!matched[x][y] && m2[x][y] == currentElement) {
                            matched[x][y] = true;
                            continue outerLoop; // Move to the next element in m1
                        }
                    }
                }

                // Not identical
                return false;
            }
        }

        return true; // Identical numbers
    }

    private static int[][] enterMatrix(Scanner scanner) {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}