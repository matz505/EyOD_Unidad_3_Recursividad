
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3_Potencias {
    double x = 1.0001;
    int n;

    // FastReader class for efficient input
    FastReader reader = new FastReader();

    static class FastReader {
        // BufferedReader to read input
        BufferedReader b;
        // StringTokenizer to tokenize input
        StringTokenizer s;

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() {
            return Integer.parseInt(next());
        }

        // Method to read Char
        char nextChar() {
            return next().charAt(0);
        }

        // Method to read the next token as a long
        long nextLong() {
            return Long.parseLong(next());
        }

        // Method to read the next token as a double
        double nextDouble() {
            return Double.parseDouble(next());
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static double powerBad(double x, int n) {
        if (n == 0)
            return 1;
        else
            return x * powerBad(x, n - 1);
    }
    public static double powerGood(double x, int n) {
        if (n == 0)
            return 1;
        double partial = powerGood(x, n / 2);
        double result = partial * partial;
        if (n % 2 == 1)
            result = result * x;
        return result;
    }
    public void leerDatos() {
        n = reader.nextInt();
    }

    public void resuelve() {
        long t1 = System.nanoTime();
        powerBad(x, n);
        long t2 = System.nanoTime();
        powerGood(x, n);
        long t3 = System.nanoTime();
        System.out.println((t2 - t1) / 1e6);
        System.out.println((t3 - t2) / 1e6);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new Thread(null, () -> {
            P3_Potencias id = new P3_Potencias();

            id.leerDatos();
            id.resuelve();
        }, "hilo", 1L << 26);
        hilo.start();
        hilo.join();
    }
}
