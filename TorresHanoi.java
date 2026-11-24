import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TorresHanoi {
    private int numero;
    private final FastReader reader = new FastReader();
    private final PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(System.out))
    );
    static class FastReader {
        private final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        private StringTokenizer st;

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String linea = br.readLine();
                    if (linea == null) {
                        return null;
                    }
                    st = new StringTokenizer(linea);
                }
                return st.nextToken();
            } catch (IOException e) {
                throw new RuntimeException("Error al leer la entrada", e);
            }
        }

        int nextInt() {
            String token = next();
            if (token == null) {
                throw new IllegalArgumentException("No se recibio el valor de N.");
            }
            return Integer.parseInt(token);
        }
    }

    public void leerDatos() {
        numero = reader.nextInt();
    }

    // Mueve n discos desde origen hasta destino usando auxiliar.
    private void torresDeHanoi(int n, char origen, char destino, char auxiliar) {
        if (n == 0) {
            return;
        }

        // Aparta los n-1 discos superiores.
        torresDeHanoi(n - 1, origen, auxiliar, destino);

        // Mueve el disco mas grande disponible al destino.
        out.println("Move disk " + n + " from rod " + origen + " to rod " + destino);

        // Coloca los n-1 discos sobre el disco mas grande.
        torresDeHanoi(n - 1, auxiliar, destino, origen);
    }

    public void resuelve() {
        if (numero < 0) {
            throw new IllegalArgumentException("N debe ser un entero no negativo.");
        }

        torresDeHanoi(numero, 'A', 'C', 'B');
        out.flush();
    }

    public static void main(String[] args) {
        TorresHanoi programa = new TorresHanoi();
        programa.leerDatos();
        programa.resuelve();
    }
}
