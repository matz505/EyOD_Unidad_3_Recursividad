import java.util.Arrays;

public class P1_SumaLinear {

    public static int linearSum(int[] data, int n) {
        if (n == 0)
            return 0;
        else
            return linearSum(data, n - 1) + data[n - 1];
    }

    public static void main(String[] args) {
        int[][] ejemplos = {
            {1, 2, 3, 4},
            {5, 10, 15},
            {7, -2, 4, 9, 1}
        };
        for (int[] d : ejemplos) {
            System.out.println("Arreglo: " + Arrays.toString(d)
                    + " -> suma = " + linearSum(d, d.length));
        }
    }
}