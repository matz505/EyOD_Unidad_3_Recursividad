import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fibonacci {

    static class FastReader {
        private final BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String linea = br.readLine();
                if (linea == null) {
                    return null;
                }
                st = new StringTokenizer(linea);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    FastReader reader = new FastReader();
    int numero;

    public void leerDatos() throws IOException {
        numero = reader.nextInt();
    }

    // recursividad simple (ineficiente).
    // Calcula F(n) mediante F(n-1) + F(n-2).
    public static long fibonacciBad(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciBad(n - 2) + fibonacciBad(n - 1);
    }

    // recursividad lineal.
    // Regresa un arreglo: [F(n), F(n-1)].
    public static long[] fibonacciGood(int n) {
        if (n <= 1) {
            return new long[]{n, 0};
        }

        long[] temp = fibonacciGood(n - 1);
        long[] answer = {
            temp[0] + temp[1],
            temp[0]
        };
        return answer;
    }

    public void resuelve() {
        if (numero < 0) {
            System.out.println("El numero debe ser mayor o igual que 0.");
            return;
        }

        long resultadoBad = fibonacciBad(numero);
        long[] resultadoGood = fibonacciGood(numero);

        System.out.println("fibonacciBad: " + resultadoBad);
        System.out.println("fibonacciGood: " + resultadoGood[0]);
        System.out.println("F(" + numero + "-1): " + resultadoGood[1]);
    }

    public static void main(String[] args) throws IOException {
        Fibonacci id = new Fibonacci();
        id.leerDatos();
        id.resuelve();
    }
}
