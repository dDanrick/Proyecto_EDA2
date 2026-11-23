package ec.edu.epn.eda2_proyecto;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class SecondaryController {

    @FXML
    private void abrirTema(ActionEvent event) throws IOException {
        Button boton = (Button) event.getSource();
        int tema = Integer.parseInt((String) boton.getUserData());
        FXMLLoader loader = App.cargar("tema");
        TemaController controlador = loader.getController();
        controlador.setTema(tema);
    }

    @FXML
    private void volver() throws IOException {
        App.setRoot("primary");
    }
}