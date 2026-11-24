import java.util.Arrays;

public class P2_ArregloReves {

    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);
        }
    }

    public static void main(String[] args) {
        int[][] ejemplos = {
            {1, 2, 3, 4, 5},
            {10, 20, 30, 40},
            {7, 8}
        };
        for (int[] d : ejemplos) {
            System.out.println("Antes:   " + Arrays.toString(d));
            reverseArray(d, 0, d.length - 1);
            System.out.println("Despues: " + Arrays.toString(d));
            System.out.println();
        }
    }
}