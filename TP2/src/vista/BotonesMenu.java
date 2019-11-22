package vista;

import javafx.scene.layout.HBox;

public class BotonesMenu extends HBox {
    public BotonesMenu(){
        super();
        this.setHeight(20);
        this.getChildren().add(new BotonSalir());
        this.getChildren().add(new BotonComenzar());
    }
}
