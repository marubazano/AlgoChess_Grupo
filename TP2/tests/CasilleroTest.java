import org.junit.*;

public class CasilleroTest {
    private Casillero pruebaCasillero = new Casillero();

    @Test
    public void CasilleroSeCreaVacio(){
        Assert.assertFalse(pruebaCasillero.estaOcupado());
    }

    @Test
    public void CasilleroEstaOcupado(){
        pruebaCasillero.ocuparCasilleroPorUnidad();
        Assert.assertTrue(pruebaCasillero.estaOcupado());
    }
}