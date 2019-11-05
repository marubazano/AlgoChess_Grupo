import com.sun.javafx.geom.DirtyRegionContainer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordenadaTest {
    /*
        Podriamos agregar pruebas para ver que se desplazan en todas las direcciones posibles
     */
    @Test
    public void compararCoordenadaDevuelveTrueSiSonIgualesTest() {
        Coordenada coordenada  = new Coordenada(3, 4);
        Coordenada otraCoordenada = new Coordenada(3,4);
        Assert.assertTrue(coordenada.compararCoordenada(otraCoordenada));
    }
}