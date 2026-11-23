module ec.edu.epn.eda2_proyecto {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.epn.eda2_proyecto to javafx.fxml;
    exports ec.edu.epn.eda2_proyecto;
}
