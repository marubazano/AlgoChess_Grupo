package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class BotonPasar extends Button {
    public BotonPasar() {
        super();
        this.setText("Pasar");
        this.setPrefSize(100,50);
        this.setAlignment(Pos.TOP_RIGHT);
    }
}
