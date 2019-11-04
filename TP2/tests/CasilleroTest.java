import org.junit.*;

public class CasilleroTest {
    private Casillero pruebaCasillero = new Casillero();
    private Unidad unidad = new Jinete();

    @Test
    public void CasilleroSeCreaVacio(){
        Assert.assertFalse(pruebaCasillero.estaOcupado());
    }

    @Test
    public void estaOcupadoDevuelveTrueCuandoEstaOcupado(){
        pruebaCasillero.ocuparCasilleroPorUnidad(unidad);
        Assert.assertTrue(pruebaCasillero.estaOcupado());
    }
}