// MatrixMultiplication.java
class MatrixMultiplication {
    static int[][] multiply(int[][] A, int[][] B) {
        int r1 = A.length, c1 = A[0].length, c2 = B[0].length;
        int[][] C = new int[r1][c2];
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    // Multithreaded version: one thread per row
    static class RowMultiplier extends Thread {
        int row;
        int[][] A, B, C;
        RowMultiplier(int row, int[][] A, int[][] B, int[][] C) {
            this.row = row; this.A = A; this.B = B; this.C = C;
        }
        public void run() {
            for (int j = 0; j < B[0].length; j++)
                for (int k = 0; k < B.length; k++)
                    C[row][j] += A[row][k] * B[k][j];
        }
    }

    static int[][] multiplyThreaded(int[][] A, int[][] B) throws InterruptedException {
        int r1 = A.length, c2 = B[0].length;
        int[][] C = new int[r1][c2];
        Thread[] threads = new Thread[r1];
        for (int i = 0; i < r1; i++) {
            threads[i] = new RowMultiplier(i, A, B, C);
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        return C;
    }

    // Utility to print a matrix
    static void printMatrix(int[][] M) {
        for (int[] row : M) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] A = { {1, 2, 3}, {4, 5, 6} };
        int[][] B = { {7, 8}, {9, 10}, {11, 12} };

        System.out.println("Normal Multiplication:");
        printMatrix(multiply(A, B));

        System.out.println("\nMultithreaded Multiplication (one thread per row):");
        printMatrix(multiplyThreaded(A, B));
    }
}
