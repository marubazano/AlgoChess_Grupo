import org.junit.*;

public class CasilleroTest {
    private Casillero pruebaCasillero = new Casillero();

    @Test
    public void CasilleroSeCreaVacio(){
        Assert.assertFalse(pruebaCasillero.estaOcupado());
    }

    @Test
    public void CasilleroEstaOcupado(){
        Unidad prueba = new Unidad();
        pruebaCasillero.ocuparCasilleroPorUnidad(prueba);
        Assert.assertTrue(pruebaCasillero.estaOcupado());
    }
}