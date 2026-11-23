package ec.edu.epn.eda2_proyecto;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void ingresar() throws IOException {
        App.setRoot("secondary");
    }
}
