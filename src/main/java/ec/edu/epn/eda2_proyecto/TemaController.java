package ec.edu.epn.eda2_proyecto;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ec.edu.epn.eda2_proyecto.ejemplos.Eficiencia;
import ec.edu.epn.eda2_proyecto.ejemplos.Complejidad;

public class TemaController {

    @FXML private Label lblTitulo;
    @FXML private Label lblTeoria;
    @FXML private ComboBox<String> cmbEjemplos;
    @FXML private TextArea txtSalida;

    private int tema;

    // Lo llama SecondaryController al abrir la pantalla
    public void setTema(int tema) {
        this.tema = tema;
        switch (tema) {
            case 1:
                lblTitulo.setText("1. Eficiencia algorítmica");
                lblTeoria.setText("La eficiencia mide cuántos recursos (tiempo y memoria) usa un algoritmo. "
                        + "Dos algoritmos pueden resolver el mismo problema con costos muy distintos, "
                        + "por ejemplo sumar 1..n con un for (O(n)) o con la fórmula de Gauss (O(1)).");
                cmbEjemplos.getItems().addAll("Suma con for vs Gauss", "Búsqueda binaria");
                break;
            case 2:
                lblTitulo.setText("2. Análisis de complejidad");
                lblTeoria.setText("La notación Big-O describe cómo crece el número de operaciones cuando crece n. "
                        + "Órdenes comunes: O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ).");
                cmbEjemplos.getItems().addAll("Comparador de complejidades");
                break;
            case 3:
                lblTitulo.setText("3. P - NP - NP-Hard - NP-Completo");
                lblTeoria.setText("P: problemas que se resuelven en tiempo polinomial. NP: su solución se VERIFICA en tiempo polinomial. "
                        + "NP-Hard: al menos tan difíciles como cualquier problema NP. NP-Completo: están en NP y son NP-Hard.");
                cmbEjemplos.getItems().addAll("Subset Sum (verificar)", "Subset Sum (resolver vs verificar)",
                        "Camino Hamiltoniano (verificar)", "Clique", "Vertex Cover");
                break;
            case 4:
                lblTitulo.setText("4. Grafos");
                lblTeoria.setText("Un grafo G = (V, E) tiene vértices y aristas. Orden topológico (Kahn): ordena tareas con dependencias en un grafo dirigido acíclico. "
                        + "Árbol de expansión mínima (Kruskal): conecta todos los vértices con el menor costo total.");
                cmbEjemplos.getItems().addAll("Representación de un grafo", "Orden topológico (Kahn)", "Árbol de expansión mínima (Kruskal)");
                break;
        }
        cmbEjemplos.getSelectionModel().selectFirst();
    }

    @FXML
    private void ejecutar() {
        String ejemplo = cmbEjemplos.getValue();
        String resultado;
        switch (ejemplo) {
            case "Suma con for vs Gauss":
                resultado = Eficiencia.sumaForVsGauss(100_000_000L);
                break;
            case "Búsqueda binaria":
                resultado = Eficiencia.busquedaBinaria(1_000_000, 777_776);
                break;
            case "Comparador de complejidades":
                resultado = Complejidad.comparar(new int[]{10, 20, 50, 100, 1000, 10000});
                 break;    
            default:
                resultado = "Este ejemplo todavía no está conectado: " + ejemplo;
    }
    txtSalida.setText(resultado);
}

    @FXML
    private void volver() throws IOException {
        App.setRoot("secondary");
    }
}