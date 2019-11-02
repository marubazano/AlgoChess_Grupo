import org.junit.*;

public class CasilleroTest {
    private Casillero pruebaCasillero = new Casillero();

    @Test
    public void CasilleroSeCreaVacio(){
        Assert.assertFalse(pruebaCasillero.estaOcupado());
    }

    @Test
    public void estaOcupadoDevuelveTrueCuandoEstaOcupado(){
        pruebaCasillero.ocuparCasilleroPorUnidad();
        Assert.assertTrue(pruebaCasillero.estaOcupado());
    }
}