import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCasillero{
    Casillero pruebaCasillero = new Casillero();

    @Test
    public void CasilleroSeCreaVacio(){
        assertEquals(pruebaCasillero.estaOcupado(), false);
    }

    @Test
    public void CasilleroEstaOcupado(){
         pruebaCasillero.ocuparCasilleroPorUnidad();
         assertEquals(pruebaCasillero.estaOcupado(), true);
     }

}