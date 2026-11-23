package ec.edu.epn.eda2_proyecto.ejemplos;

public class Complejidad {

    // Cuenta operaciones reales de algoritmos típicos de cada orden
    public static String comparar(int[] tamanos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%8s %8s %10s %10s %12s %14s %22s%n",
                "n", "O(1)", "O(log n)", "O(n)", "O(n log n)", "O(n²)", "O(2ⁿ)"));
        sb.append("-".repeat(92)).append("\n");

        for (int n : tamanos) {
            long c1 = constante(n);
            long cLog = logaritmica(n);
            long cN = lineal(n);
            long cNLog = nLogN(n);
            long cN2 = cuadratica(n);
            String c2n = (n <= 62) ? String.valueOf(1L << n) : "demasiado grande";

            sb.append(String.format("%8d %8d %10d %10d %12d %14d %22s%n",
                    n, c1, cLog, cN, cNLog, cN2, c2n));
        }

        sb.append("\nConclusión: al crecer n, O(1) y O(log n) casi no cambian,\n")
          .append("O(n) y O(n log n) crecen de forma manejable, O(n²) se dispara\n")
          .append("y O(2ⁿ) se vuelve imposible incluso con n pequeños.");
        return sb.toString();
    }

    // O(1): acceder a un elemento de un arreglo
    private static long constante(int n) {
        return 1;
    }

    // O(log n): dividir n a la mitad hasta llegar a 1 (como la búsqueda binaria)
    private static long logaritmica(int n) {
        long ops = 0;
        while (n > 1) { n /= 2; ops++; }
        return ops;
    }

    // O(n): recorrer el arreglo una vez
    private static long lineal(int n) {
        long ops = 0;
        for (int i = 0; i < n; i++) ops++;
        return ops;
    }

    // O(n log n): por cada elemento, una división a la mitad (como merge sort)
    private static long nLogN(int n) {
        long ops = 0;
        for (int i = 0; i < n; i++) ops += logaritmica(n);
        return ops;
    }

    // O(n²): dos for anidados (como burbuja)
    private static long cuadratica(int n) {
        long ops = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) ops++;
        return ops;
    }
}