package vista;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class CasilleroVista extends Pane {
    Button buton;


    public CasilleroVista (Button boton) {
        this.buton = boton;
        this.buton.setPrefSize(60,60);
    }

    public void deshabilitarBoton() {
        this.buton.setDisable(true);
    }

    public void habilitarBoton() {
        this.buton.setDisable(false);
    }
}
