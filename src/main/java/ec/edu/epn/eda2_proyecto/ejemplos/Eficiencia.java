package ec.edu.epn.eda2_proyecto.ejemplos;

public class Eficiencia {

    // Suma de 1..n con un for: O(n)
    public static String sumaForVsGauss(long n) {
        long inicio = System.nanoTime();
        long sumaFor = 0;
        for (long i = 1; i <= n; i++) {
            sumaFor += i;
        }
        long tiempoFor = System.nanoTime() - inicio;

        inicio = System.nanoTime();
        long sumaGauss = n * (n + 1) / 2;   // Fórmula de Gauss: O(1)
        long tiempoGauss = System.nanoTime() - inicio;

        return "n = " + n + "\n\n"
             + "Con for  (O(n)): suma = " + sumaFor + "  tiempo = " + tiempoFor + " ns\n"
             + "Con Gauss (O(1)): suma = " + sumaGauss + "  tiempo = " + tiempoGauss + " ns\n\n"
             + "Ambos dan el mismo resultado, pero el for hace n sumas\n"
             + "y Gauss solo una operación sin importar n.";
    }

    // Búsqueda lineal O(n) vs binaria O(log n) en un arreglo ordenado
    public static String busquedaBinaria(int n, int buscado) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i * 2;   // arreglo ordenado de pares

        int pasosLineal = 0, posLineal = -1;
        for (int i = 0; i < n; i++) {
            pasosLineal++;
            if (arr[i] == buscado) { posLineal = i; break; }
        }

        int pasosBinaria = 0, posBinaria = -1;
        int izq = 0, der = n - 1;
        while (izq <= der) {
            pasosBinaria++;
            int medio = (izq + der) / 2;
            if (arr[medio] == buscado) { posBinaria = medio; break; }
            else if (arr[medio] < buscado) izq = medio + 1;
            else der = medio - 1;
        }

        return "Arreglo ordenado de " + n + " pares, buscando " + buscado + "\n\n"
             + "Búsqueda lineal  (O(n)):     posición " + posLineal + "  en " + pasosLineal + " pasos\n"
             + "Búsqueda binaria (O(log n)): posición " + posBinaria + "  en " + pasosBinaria + " pasos\n\n"
             + (posBinaria == -1 ? "El número no está (solo hay pares).\n" : "")
             + "La binaria divide el arreglo a la mitad en cada paso.";
    }
}
